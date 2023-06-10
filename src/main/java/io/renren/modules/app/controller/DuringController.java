package io.renren.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.RuleEntity;
import io.renren.modules.app.entity.SiteEntity;
import io.renren.modules.app.entity.SiteUserEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.RuleService;
import io.renren.modules.app.service.SiteService;
import io.renren.modules.app.service.SiteUserService;
import io.renren.modules.app.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 *
 * 预定controller
 */
@RestController
@RequestMapping("app/during")
public class DuringController {

    @Autowired
    private SiteUserService siteUserService;

    @Autowired
    private RuleService ruleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SiteService siteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:rule:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = siteUserService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SiteUserEntity siteUserEntity) {
        QueryWrapper<SiteUserEntity> siteUserQuery = new QueryWrapper<>();
        siteUserQuery.eq("sid", siteUserEntity.getSid());
        siteUserQuery.eq("during_date", siteUserEntity.getDuringDate());
        siteUserQuery.eq("during_time", siteUserEntity.getDuringTime());
        List siteUserList = siteUserService.list(siteUserQuery);
        if (siteUserList.size() > 0) {
            return R.error("预定失败,该场地已被预定");
        }
        siteUserService.save(siteUserEntity);
        UserEntity userEntity = userService.getById(siteUserEntity.getUid());

        QueryWrapper<RuleEntity> ruleQuery = new QueryWrapper<>();
        ruleQuery.eq("userlevel", userEntity.getRole());
        ruleQuery.lt("startTime", new Date());
        ruleQuery.gt("endTime", new Date());
        List<RuleEntity> ruleList = ruleService.list(ruleQuery);

        if (ruleList.size() > 0) {
            BigDecimal balance = userEntity.getMoney().subtract(ruleList.get(0).getPrice());
            userEntity.setMoney(balance);
        } else {
            SiteEntity siteEntity = siteService.getById(siteUserEntity.getSid());
            BigDecimal balance = userEntity.getMoney().subtract(siteEntity.getPrice());
            userEntity.setMoney(balance);
        }

        userEntity.setUid(siteUserEntity.getUid());
        userService.updateById(userEntity);
        return R.ok();
    }
}

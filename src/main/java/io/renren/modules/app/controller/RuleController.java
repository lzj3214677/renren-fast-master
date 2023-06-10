package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.RuleEntity;
import io.renren.modules.app.service.RuleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 规则表
 *
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@RestController
@RequestMapping("app/rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:rule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ruleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rid}")
    @RequiresPermissions("app:rule:info")
    public R info(@PathVariable("rid") Integer rid){
		RuleEntity rule = ruleService.getById(rid);

        return R.ok().put("rule", rule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:rule:save")
    public R save(@RequestBody RuleEntity rule){
		ruleService.save(rule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:rule:update")
    public R update(@RequestBody RuleEntity rule){
		ruleService.updateById(rule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:rule:delete")
    public R delete(@RequestBody Integer[] rids){
		ruleService.removeByIds(Arrays.asList(rids));

        return R.ok();
    }

}

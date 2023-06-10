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

import io.renren.modules.app.entity.SiteEntity;
import io.renren.modules.app.service.SiteService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 场地表
 *
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@RestController
@RequestMapping("app/site")
public class SiteController {
    @Autowired
    private SiteService siteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:site:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = siteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sid}")
    @RequiresPermissions("app:site:info")
    public R info(@PathVariable("sid") Integer sid){
		SiteEntity site = siteService.getById(sid);

        return R.ok().put("site", site);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:site:save")
    public R save(@RequestBody SiteEntity site){
		siteService.save(site);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:site:update")
    public R update(@RequestBody SiteEntity site){
		siteService.updateById(site);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:site:delete")
    public R delete(@RequestBody Integer[] sids){
		siteService.removeByIds(Arrays.asList(sids));

        return R.ok();
    }

}

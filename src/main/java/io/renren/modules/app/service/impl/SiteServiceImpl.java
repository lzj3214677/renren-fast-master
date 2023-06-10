package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SiteDao;
import io.renren.modules.app.entity.SiteEntity;
import io.renren.modules.app.service.SiteService;


@Service("siteService")
public class SiteServiceImpl extends ServiceImpl<SiteDao, SiteEntity> implements SiteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<SiteEntity> queryWrapper = new QueryWrapper<SiteEntity>();
        if (null != params.get("name")) {
            queryWrapper.like("name", params.get("name"));
        }

        if (null != params.get("price")) {
            queryWrapper.eq("price", params.get("price"));
        }

        IPage<SiteEntity> page = this.page(
            new Query<SiteEntity>().getPage(params),
            queryWrapper
        );

        return new PageUtils(page);
    }

}
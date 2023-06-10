package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SiteEntity;

import java.util.Map;

/**
 * 场地表
 *
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
public interface SiteService extends IService<SiteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


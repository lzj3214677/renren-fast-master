package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SiteUserEntity;

import java.util.Map;

/**
 * @author admin
 */
public interface SiteUserService extends IService<SiteUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.SiteUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Mapper
public interface SiteUserDao extends BaseMapper<SiteUserEntity> {

    List<Map<String, Object>> selectReport(@Param("page") Integer page, @Param("limit") Integer limit, @Param("duringDate") Object duringDate);
}

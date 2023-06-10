package io.renren.modules.app.dao;

import io.renren.modules.app.entity.RuleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 规则表
 * 
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@Mapper
public interface RuleDao extends BaseMapper<RuleEntity> {
	
}

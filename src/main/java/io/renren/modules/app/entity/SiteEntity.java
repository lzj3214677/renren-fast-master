package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 场地表
 * 
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@Data
@TableName("site")
public class SiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer sid;
	/**
	 * 场地名
	 */
	private String name;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 楼层
	 */
	private String floor;
	/**
	 * 面积
	 */
	private BigDecimal area;

}

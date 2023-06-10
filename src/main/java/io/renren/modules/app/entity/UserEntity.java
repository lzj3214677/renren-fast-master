package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	@TableId
	private Integer uid;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 账号
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 余额
	 */
	private BigDecimal money;

	/**
	 * 电话
	 */
	private String mobile;

	/**
	 * 创建日期
	 */
	private Date createTime;

}

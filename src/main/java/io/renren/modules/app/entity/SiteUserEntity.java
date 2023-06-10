package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 *
 * 预定实体类
 */
@Data
@TableName("site_and_user")
public class SiteUserEntity implements Serializable {

    private Integer uid;

    private Integer sid;

    private Date duringDate;

    private String duringTime;
}

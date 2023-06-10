package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 规则表
 *
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
@Data
@TableName("rule")
public class RuleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Integer rid;
    /**
     * 用户等级
     */
    private String userlevel;
    /**
     * 开始时间
     */
    private Date starttime;
    /**
     * 结束时间
     */
    private Date endtime;
    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 场地id
     */
    private Integer sid;

}

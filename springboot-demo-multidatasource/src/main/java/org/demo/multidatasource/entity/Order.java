package org.demo.multidatasource.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table(name = "t_order")
@Data
@ToString
public class Order implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 订单名称
     */
    @Column(name = "order_name")
    private String orderName;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
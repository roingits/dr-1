package cn.dr.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author zcw
* @since 2019-06-26
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class DrOrder implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 订单id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 订单号
            */
    private Long orderNo;

            /**
            * 用户id
            */
    private Integer userId;

    private Integer shippingId;

            /**
            * 实际付款金额，单位元，保留2位小数
            */
    private BigDecimal payment;

            /**
            * 支付类型，1-在线支付
            */
    private Integer paymentType;

            /**
            * 运费，单位是元
            */
    private Integer postage;

            /**
            * 订单状态：0-已取消，10-未付款，20-已付款，40-已发货
            */
    private Integer status;

            /**
            * 支付时间
            */
    private LocalDateTime paymentTime;

            /**
            * 发货时间
            */
    private LocalDateTime sendTime;

            /**
            * 交易完成时间
            */
    private LocalDateTime endTime;

            /**
            * 交易关闭时间
            */
    private LocalDateTime closeTime;

            /**
            * 创建时间
            */
    private LocalDateTime createTime;

            /**
            * 更新时间
            */
    private LocalDateTime updateTime;


}

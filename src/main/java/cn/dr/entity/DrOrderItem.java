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
    public class DrOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 订单子表id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Long orderNo;

            /**
            * 商品id
            */
    private Integer productId;

            /**
            * 商品名称
            */
    private String productName;

            /**
            * 商品图片地址
            */
    private String productImage;

            /**
            * 生成订单时的商品单价，单位是元，保留两位小数
            */
    private BigDecimal currentUnitPrice;

            /**
            * 商品数量
            */
    private Integer quantity;

            /**
            * 商品总价，单元是元，保留两位小数
            */
    private BigDecimal totalPrice;

            /**
            * 创建时间
            */
    private LocalDateTime createTime;

            /**
            * 更新时间
            */
    private LocalDateTime updateTime;


}

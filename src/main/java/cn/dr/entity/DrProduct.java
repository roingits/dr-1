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
 * @since 2019-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DrProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类id，对应mall_category表的主键
     */
    private Integer categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品副标题
     */
    private String subtitle;

    /**
     * 产品主图，url相对地址
     */
    private String mainImage;

    /**
     * 图片地址，json格式
     */
    private String subImages;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 价格，单位元，保留2位小数
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 商品状态，1-在售 2-下架 3-删除
     */
    private Integer status;

    /**
     * 钻石重量
     */
    private Integer quality;

    /**
     * 商品材质id
     */
    private Integer textureId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

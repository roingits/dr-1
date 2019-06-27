package cn.dr.entity;

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
public class DrShipping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收货表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收货姓名
     */
    private String receiverName;

    /**
     * 收货固定电话
     */
    private String receiverPhone;

    /**
     * 收货移动电话
     */
    private String receiverMobile;

    /**
     * 省份
     */
    private String receiverProvince;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 区/县
     */
    private String receiverDistrict;

    /**
     * 详细地址
     */
    private String receicerAddress;

    /**
     * 邮编
     */
    private String receiverZip;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

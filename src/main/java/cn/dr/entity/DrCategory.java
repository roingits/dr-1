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
public class DrCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父类id当id=0时说明是根节点,一级类别
     */
    private Integer parentId;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别状态1-正常，2-已废弃
     */
    private Boolean status;

    /**
     * 排序编号，同类展示顺序，数值相等则自然排序
     */
    private Integer sortOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

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
* @since 2019-06-26
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class DrNewPicture implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 流水号id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 新闻id
            */
    private Integer newId;

            /**
            * 图片地址
            */
    private String subImages;

            /**
            * 创建时间
            */
    private LocalDateTime createTime;

            /**
            * 更新时间
            */
    private LocalDateTime updateTime;


}

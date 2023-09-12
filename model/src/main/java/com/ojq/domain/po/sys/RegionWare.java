package com.ojq.domain.po.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 城市仓库关联表
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("region_ware")
public class RegionWare implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 开通区域id
     */
    private Long regionId;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 仓库
     */
    private Long wareId;

    /**
     * 仓库名称
     */
    private String wareName;

    /**
     * 状态（0：未开通 1：已开通）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记（0:不可用 1:可用）
     */
    private Integer isDeleted;


}

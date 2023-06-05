package org.zhangbo.wiki_back.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangbo
 * @since 2023-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_keywords")
@Builder
@ApiModel(value = "Keywords对象", description = "")
public class Keywords implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "知识库中每条知识的id，通过雪花算法生成，不会有重复")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "用户名,对应用户表里的name")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "关键词，一般为两到三个")
    @TableField("key_words")
    private String keyWords;

    @ApiModelProperty(value = "点赞数")
    @TableField("likes")
    private Long likes;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;


}

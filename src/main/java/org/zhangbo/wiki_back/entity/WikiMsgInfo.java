package org.zhangbo.wiki_back.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

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
@ApiModel(value = "WikiMsgInfo对象", description = "这里做了分表，通过用户id进行的分表，具体的表名从视图里面可以查询到")
public class WikiMsgInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "知识库中每条知识的id，通过雪花算法生成，不会有重复")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "用户名,对应用户表里的name")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "原作者")
    @TableField("forked_author")
    private String forkedAuthor;

    @ApiModelProperty(value = "知识标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "关键词，一般为两到三个")
    @TableField("key_words")
    private String keyWords;

    @ApiModelProperty(value = "知识内容")
    @TableField("content")
    private Blob content;

    @ApiModelProperty(value = "fork别人的文章，我们只需要将对方文章的id放进来即可，如此不用存储content，减少存储")
    @TableField("forked_id")
    private String forkedId;

    @ApiModelProperty(value = "点赞数")
    @TableField("likes")
    private Long likes;

    @ApiModelProperty(value = "访问数")
    @TableField("watches")
    private Long watches;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedTime;


}

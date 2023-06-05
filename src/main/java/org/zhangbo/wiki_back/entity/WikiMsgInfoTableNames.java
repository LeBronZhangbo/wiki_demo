package org.zhangbo.wiki_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author zhangbo
 * @since 2023-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("v_wiki_msg_info_table_names")
@ApiModel(value = "WikiMsgInfoTableNames对象", description = "VIEW")
public class WikiMsgInfoTableNames implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("table_name")
    private String tableName;


}

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
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zhangbo
 * @since 2023-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_info")
@Builder
@ApiModel(value = "UserInfo对象", description = "用户信息表")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "邮箱")
    @TableField("email_address")
    private String emailAddress;

    @ApiModelProperty(value = "手机号，可为空")
    @TableField("phone_number")
    private String phoneNumber;

    @ApiModelProperty(value = "用户的账号，系统生成，不可修改，生成规则为随机生成10位字母加数字")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "用户密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modified_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "0 普通用户；1 管理员")
    @TableField(value = "role", fill = FieldFill.INSERT_UPDATE)
    private Integer role;


}

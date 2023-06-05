package org.zhangbo.wiki_back.dto.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Name: UserRequestDto
 * @Description: 用户请求Dto
 * @Author: zhangbo
 * @Date: 2023/6/1 15:07
 */
@Data
@ApiModel("用户请求Dto")
public class UserRequestDto {

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty(value = "邮箱")
    private String emailAddress;

    @ApiModelProperty(value = "手机号，可为空")
    private String phoneNumber;

    @ApiModelProperty(value = "用户的账号，系统生成，不可修改，生成规则为随机生成10位字母加数字")
    private String account;

    @ApiModelProperty(value = "用户密码")
    private String password;


    @ApiModelProperty(value = "0 普通用户；1 管理员")
    private Integer role;


}

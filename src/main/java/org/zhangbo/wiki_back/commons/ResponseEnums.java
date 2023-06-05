package org.zhangbo.wiki_back.commons;

/**
 * @Name: ResponseEmums
 * @Description: 返回值的code的枚举类
 * @Author: zhangbo
 * @Date: 2023/6/1 15:48
 */

public enum ResponseEnums {


    USER_EXISTS(4001, "用户已存在"),
    PASSWORD_WRONG(4002,"密码错误"),
    SERVER_ERROR(5001, "服务器出错，请联系管理员"),
    SUCCESS(2000, "操作成功"),
    DATA_EMPTY(5002, "传入信息为空");


    private final Integer code;
    private final String msg;

    private ResponseEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

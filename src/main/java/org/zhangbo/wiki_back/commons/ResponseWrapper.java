package org.zhangbo.wiki_back.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Name: ResponseWrapper
 * @Description: 通用封装返回对象
 * @Author: zhangbo
 * @Date: 2023/6/1 11:55
 */
@AllArgsConstructor
@Data
@Builder
public class ResponseWrapper<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseWrapper<T> success(String msg, T data) {
        return new ResponseWrapper<T>(ResponseEnums.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseWrapper<T> error(Integer code, String msg) {
        return new ResponseWrapper<T>(code, msg, null);
    }
}

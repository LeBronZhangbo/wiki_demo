package org.zhangbo.wiki_back.service;

import org.zhangbo.wiki_back.commons.ResponseWrapper;
import org.zhangbo.wiki_back.dto.user.UserRequestDto;

/**
 * @Name: UserService
 * @Description: 用户的服务接口，包括登录注册修改密码
 * @Author: zhangbo
 * @Date: 2023/6/1 15:21
 */
public interface UserService {
    public ResponseWrapper register(UserRequestDto userRequestDto);

    public ResponseWrapper login(UserRequestDto userRequestDto);

    public ResponseWrapper modify(UserRequestDto userRequestDto);

}

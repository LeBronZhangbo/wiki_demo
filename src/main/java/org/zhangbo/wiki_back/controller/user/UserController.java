package org.zhangbo.wiki_back.controller.user;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhangbo.wiki_back.commons.ResponseEnums;
import org.zhangbo.wiki_back.commons.ResponseWrapper;
import org.zhangbo.wiki_back.dto.user.UserRequestDto;
import org.zhangbo.wiki_back.service.UserService;

/**
 * @Name: UserController
 * @Description: 用户的Controller，提供注册、登录、修改密码等操作
 * @Author: zhangbo
 * @Date: 2023/6/1 15:05
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseWrapper register(@RequestBody UserRequestDto userRequestDto) {
        log.info("入参：{}", userRequestDto);
        if (BeanUtil.isEmpty(userRequestDto)) {
            return ResponseWrapper.error(ResponseEnums.DATA_EMPTY.getCode(), "传入用户信息为空");
        }
        return userService.register(userRequestDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseWrapper login(@RequestBody UserRequestDto userRequestDto) {
        log.info("入参：{}", userRequestDto);
        if (BeanUtil.isEmpty(userRequestDto)) {
            return ResponseWrapper.error(ResponseEnums.DATA_EMPTY.getCode(), "传入用户信息为空");
        }
        return userService.login(userRequestDto);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseWrapper modify(@RequestBody UserRequestDto userRequestDto) {
        log.info("入参：{}", userRequestDto);
        if (BeanUtil.isEmpty(userRequestDto)) {
            return ResponseWrapper.error(ResponseEnums.DATA_EMPTY.getCode(), "传入用户信息为空");
        }
        return userService.modify(userRequestDto);
    }
}

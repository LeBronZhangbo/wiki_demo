package org.zhangbo.wiki_back.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zhangbo.wiki_back.commons.ResponseEnums;
import org.zhangbo.wiki_back.commons.ResponseWrapper;
import org.zhangbo.wiki_back.dto.user.UserRequestDto;
import org.zhangbo.wiki_back.entity.UserInfo;
import org.zhangbo.wiki_back.mapper.UserInfoMapper;
import org.zhangbo.wiki_back.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name: UserServiceImpl
 * @Description: UserService的实现类
 * @Author: zhangbo
 * @Date: 2023/6/1 15:25
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Value("${wiki_back.base_patterns}")
    private String basePattern;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseWrapper register(UserRequestDto userRequestDto) {
        UserInfo userInfo = UserInfo.builder().name(userRequestDto.getName()).emailAddress(userRequestDto.getEmailAddress()).account(RandomUtil.randomString(basePattern, 10)).password(SecureUtil.md5(userRequestDto.getPassword())).phoneNumber(userRequestDto.getPhoneNumber()).role(userRequestDto.getRole()).build();
        if (userInfoMapper.exists(new QueryWrapper<UserInfo>().eq("email_address", userRequestDto.getEmailAddress()))) {
            return ResponseWrapper.error(ResponseEnums.USER_EXISTS.getCode(), ResponseEnums.USER_EXISTS.getMsg());
        }
        if (userInfoMapper.insert(userInfo) != 1) {
            return ResponseWrapper.error(ResponseEnums.SERVER_ERROR.getCode(), ResponseEnums.SERVER_ERROR.getMsg());
        }
        return ResponseWrapper.success("注册成功", userRequestDto);
    }

    @Override
    public ResponseWrapper login(UserRequestDto userRequestDto) {
        if (StrUtil.isEmpty(userRequestDto.getEmailAddress()) && StrUtil.isEmpty(userRequestDto.getPhoneNumber())) {
            return ResponseWrapper.error(ResponseEnums.DATA_EMPTY.getCode(), "邮箱和手机号登录时必填其一");
        }
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put("email_address", userRequestDto.getEmailAddress());
        loginMap.put("phone_number", userRequestDto.getPhoneNumber());
        loginMap.put("password", SecureUtil.md5(userRequestDto.getPassword()));
        long count = userInfoMapper.checkUserExistByMap(loginMap);
        if (count == 0) {
            return ResponseWrapper.error(ResponseEnums.PASSWORD_WRONG.getCode(), ResponseEnums.PASSWORD_WRONG.getMsg());
        } else {
            return ResponseWrapper.success("登录成功", userRequestDto);
        }
    }

    @Override
    public ResponseWrapper modify(UserRequestDto userRequestDto) {
        Map<String, String> modifyMap = new HashMap<>();
        modifyMap.put("email_address", userRequestDto.getEmailAddress());
        modifyMap.put("phone_number", userRequestDto.getPhoneNumber());
        modifyMap.put("name", userRequestDto.getName());
        modifyMap.put("password", SecureUtil.md5(userRequestDto.getPassword()));
        try {
            userInfoMapper.modifyPwdOrName(modifyMap);
        } catch (Exception e) {
            log.error("出现异常，异常为:{}", e.toString());
            return ResponseWrapper.error(ResponseEnums.SERVER_ERROR.getCode(), ResponseEnums.SERVER_ERROR.getMsg());
        }
        return ResponseWrapper.success("修改成功", userRequestDto);
    }
}

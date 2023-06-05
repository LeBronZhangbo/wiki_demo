package org.zhangbo.wiki_back.mapper;

import org.zhangbo.wiki_back.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2023-06-01
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    public long checkUserExistByMap(Map<String, String> map);

    public void modifyPwdOrName(Map<String, String> map);
}

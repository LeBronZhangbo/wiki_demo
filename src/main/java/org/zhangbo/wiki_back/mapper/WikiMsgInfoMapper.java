package org.zhangbo.wiki_back.mapper;

import org.zhangbo.wiki_back.entity.WikiMsgInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2023-06-01
 */
public interface WikiMsgInfoMapper extends BaseMapper<WikiMsgInfo> {
    public void createTableByID(String id);
}

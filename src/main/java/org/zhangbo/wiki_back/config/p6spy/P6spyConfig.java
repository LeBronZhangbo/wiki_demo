package org.zhangbo.wiki_back.config.p6spy;

import cn.hutool.json.JSONUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Name: P6spyConfig
 * @Description: sql日志打印配置
 * @Author: zhangbo
 * @Date: 2023/6/1 14:20
 */
public class P6spyConfig implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        Map<String, Object> message = new LinkedHashMap<>(8);
        String newPrepared = prepared.replace("   ", "").replace("\n", " ");
        message.put("prepared", newPrepared);
        String newSql = sql.replace("   ", "").replace("\n", " ");
        message.put("sql", newSql);
        return JSONUtil.toJsonStr(message);
    }
}

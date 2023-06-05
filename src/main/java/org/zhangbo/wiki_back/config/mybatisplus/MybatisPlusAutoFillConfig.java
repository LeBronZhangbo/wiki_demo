package org.zhangbo.wiki_back.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Name: MybatisPlusAutoFillConfig
 * @Description: mybatisplus自动填充的数据控制类
 * @Author: zhangbo
 * @Date: 2023/6/1 10:58
 */
@Slf4j
@Component
public class MybatisPlusAutoFillConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> new Timestamp(System.currentTimeMillis()), Timestamp.class); // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "modifiedTime", () -> new Timestamp(System.currentTimeMillis()), Timestamp.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "modifiedTime", () -> new Timestamp(System.currentTimeMillis()), Timestamp.class); // 起始版本 3.3.3(推
    }
}

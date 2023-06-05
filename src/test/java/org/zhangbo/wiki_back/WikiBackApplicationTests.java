package org.zhangbo.wiki_back;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zhangbo.wiki_back.entity.Keywords;
import org.zhangbo.wiki_back.mapper.KeywordsMapper;
import org.zhangbo.wiki_back.utils.AesEncryptUtil;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
@Slf4j
class WikiBackApplicationTests {

    @Test
    void contextLoads() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

    @Resource
    private KeywordsMapper keywordsMapper;

    @Test
    void testInsert() {
        Keywords keywords = Keywords.builder()
                .author("张波6666").keyWords("java").likes(0L)
                .build();
        System.out.println(keywordsMapper.insert(keywords));
//        keywordsMapper.update(keywords, new QueryWrapper<Keywords>().eq("author", "张波666"));
    }

    @Test
    void testQuery() {
        List<Keywords> keywords = keywordsMapper.selectList(null);
        System.out.println(keywords);
    }

    @Test
    void testRandom() {
        System.out.println(RandomUtil.randomString("wiki1234567890", 10));
        String pwd = "touruntudecha";
        System.out.println(SecureUtil.md5(pwd));
    }

    @Test

   void getPwd() throws Exception {
        log.info("加密前的数据：Hbwz@2022!");
        log.info("加密后的数据:{}",AesEncryptUtil.encrypt("Hbwz@2022!"));
        log.info("数据库里的数据为：1e4292c6215c0888fd3d3a5a8a25c1418fe6f81c901a771368f2e6fa7afb4a6f");
        log.info( SaSecureUtil.sha256("Hbwz@2023!"));
    }

}

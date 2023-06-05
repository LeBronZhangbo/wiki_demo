package org.zhangbo.wiki_back;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;

/**
 * @author zhangbo
 */
@SpringBootApplication
@MapperScan("org.zhangbo.wiki_back.mapper")
@Slf4j
@EnableWebMvc
public class WikiBackApplication {


    private static String projectVersion;

    private static String projectName;

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext context = SpringApplication.run(WikiBackApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        System.out.println("\n\n ============> " + projectName + "服务启动成功！版本号为：" + projectVersion + "\n 后台地址：http://localhost:" + environment.getProperty("server.port")
                + environment.getProperty("server.servlet.context-path") + " <============");
    }

    @Value("${wiki_back.project_name}")
    public void initName(String s) {
        projectName = s;
    }

    @Value("${wiki_back.project_version}")
    public void initVersion(String s) {
        projectVersion = s;
    }
}

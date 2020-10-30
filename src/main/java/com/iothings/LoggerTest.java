package com.iothings;

import com.iothings.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Huanglei
 * @time:2020/10/27 10:39 AM
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1(){
        String name="logis";
        String password="123456";
        log.debug("debug...");
        log.info("name: "+name);
        log.info("name: {}, password: {}",name,password);
        log.error("error...");
    }


    /**
     * Logback配置
     * 1、application.properties
     * 输出格式： logging.pattern.console="%d - %msg%n"
     * 输出路径： logging.file.path="/var/log/tomcat"
     * 文件：
     * 级别：     level：debug    也可以指定类的级别
     *
     *
     *
     * 2、logback-spring.xml   区分info和error，每天产生一个日志文件；
     *
     */
}

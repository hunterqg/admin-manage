package org.bumishi.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xieqiang on 2016/9/11.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAdminServer
@Configuration
@ComponentScan("org.bumishi.admin,com.cm.mm")
@MapperScan("com.cm.mm.dao.mapper")
public class AdminApplication {

    public static void main(String[] arg){
        SpringApplication.run(AdminApplication.class);
    }

}
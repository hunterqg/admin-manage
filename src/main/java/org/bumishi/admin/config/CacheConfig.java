package org.bumishi.admin.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 后台应用，不考虑集群需求，使用guava作为cache
 * @author qiang.xie
 * @date 2016/10/31
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cache.guava")
@EnableCaching(proxyTargetClass = true)
public class CacheConfig {

    private String spec;

    @Bean
    protected CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.from(spec));
        return cacheManager;
    }


    public void setSpec(String spec) {
        this.spec = spec;
    }
}

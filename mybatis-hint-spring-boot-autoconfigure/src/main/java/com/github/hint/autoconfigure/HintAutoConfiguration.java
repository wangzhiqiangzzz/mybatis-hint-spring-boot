package com.github.hint.autoconfigure;

import com.github.hint.HintInterceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName HintAutoConfiguration
 * @Description
 * @Author wzq
 * @Date 2025/5/19 15:07
 * @Version 1.0
 */

@Configuration
@EnableConfigurationProperties(HintProperties.class)
@ConditionalOnProperty(value = "hint.enable", havingValue = "true")
@Lazy(false)
public class HintAutoConfiguration {


    @Bean
    public HintInterceptor hintInterceptor() {
        return new HintInterceptor();
    }
}

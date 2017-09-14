package com.lrcf.yhb.statistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Spring boot启动类
 * Created by Krx on 2017/6/13.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lrcf.yhb.user.api","com.lrcf.yhb.admin.controller","com.lrcf.yhb.product.api","com.lrcf.yhb.statistic.controller"})
@ImportResource({"classpath:dubbo-statistic.xml"})
public class YHBStatisticApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YHBStatisticApiApplication.class, args);
    }


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("Content-Type");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setMaxAge(Long.parseLong("3600"));
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}

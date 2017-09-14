package com.lrcf.yhb.admin;

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
@ComponentScan(basePackages = {"com.lrcf.yhb.user.api","com.lrcf.yhb.admin.controller"
        ,"com.lrcf.yhb.product.api"})
@ImportResource({"classpath:dubbo-admin.xml"})
public class YHBAdminApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YHBAdminApiApplication.class, args);
    }


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://192.168.1.56:8080");
        corsConfiguration.addAllowedHeader("content-type");
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

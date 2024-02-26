package com.hermes.crud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.hermes.crud") public class MybatisConfiguration {
}

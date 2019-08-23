package com.easicare.device.config;

/**
 * @author df
 * @date 2019/8/6
 */
/*@EnableAutoConfiguration
@Configuration*/
public class MybatisPlusConfig {
    /**
     * 性能优化  复杂查询可能会报错 建议关掉
     */
   /* @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        *//*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*//*
        performanceInterceptor.setMaxTime(1000);
        *//*<!--SQL是否格式化 默认false-->*//*
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }*/

    /**
     * 分页插件
     */
   /* @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }*/

}

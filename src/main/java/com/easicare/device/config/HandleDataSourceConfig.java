package com.easicare.device.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author df
 * @date 2019/8/19
 */
@Configuration
@MapperScan(basePackages = "com.easicare.device.mapper.handle",sqlSessionFactoryRef = "handleSqlSessionFactory")
public class HandleDataSourceConfig {
    @Primary
    @Bean(name = "handleDataSource")
    @ConfigurationProperties("spring.datasource.handle")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "handleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("handleDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/handle/*.xml"));

        // 设置分页插件, 其他的插件也是一样的使用的时候添加到列表一起设置即可
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new PaginationInterceptor());
        sessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
        return sessionFactoryBean.getObject();
    }

}

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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author df
 * @date 2019/8/19
 */
@Configuration
@MapperScan(basePackages = "com.easicare.device.mapper.team",sqlSessionFactoryRef = "teamSqlSessionFactory")
public class TeamDataSourceConfig {
    @Bean(name = "teamDataSource")
    @ConfigurationProperties("spring.datasource.team")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "teamSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("teamDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/team/*.xml"));

        // 设置分页插件, 其他的插件也是一样的使用的时候添加到列表一起设置即可
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new PaginationInterceptor());
        sessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
        return sessionFactoryBean.getObject();
    }
}

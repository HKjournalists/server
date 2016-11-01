package com.software.server.dao.base;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "com.software.server.dao.page")
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(sqlSessionFactoryRef = "sqlSessionFactory",basePackages = "com.software.server.dao.mapper",annotationClass = MyBatisMapper.class)
@Import(DataSourceConfig.class)
public class DaoConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        PropertySourcesPlaceholderConfigurer propertyConfig = new PropertySourcesPlaceholderConfigurer();
        propertyConfig.setIgnoreResourceNotFound(true);
        propertyConfig.setOrder(2);
        return propertyConfig;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:config/mybatis-config.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.software.server.dao.model");
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper()});
        try{
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:config/mapper/*.xml"));
            return sqlSessionFactoryBean.getObject();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }


    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}

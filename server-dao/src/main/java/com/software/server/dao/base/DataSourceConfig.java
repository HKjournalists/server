package com.software.server.dao.base;


import com.alibaba.druid.pool.DruidDataSource;
import com.software.server.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.sql.DataSource;

/**
 * 配置数据源
 */
@Configuration
@PropertySources({@PropertySource(value = {"classpath:config/database.properties"},ignoreResourceNotFound = true)})
public class DataSourceConfig {

    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.maxActive}")
    private String maxActive;
    @Value("${db.initialSize}")
    private String initialSize;
    @Value("${db.maxWait}")
    private String maxWait;
    @Value("${db.minIdle}")
    private String minIdle;
    @Value("${db.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${db.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;
    @Value("${db.validationQuery}")
    private String validationQuery;
    @Value("${db.testWhileIdle}")
    private String testWhileIdle;
    @Value("${db.testOnBorrow}")
    private String testOnBorrow;
    @Value("${db.testOnReturn}")
    private String testOnReturn;
    @Value("${db.removeAbandoned}")
    private String removeAbandoned;
    @Value("${db.removeAbandonedTimeout}")
    private String removeAbandonedTimeout;

    /**
     * 数据源
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(Integer.parseInt(StringUtils.trimNull(maxActive, "50")));
        druidDataSource.setInitialSize(Integer.parseInt(StringUtils.trimNull(initialSize, "1")));
        druidDataSource.setMaxWait(Long.parseLong(StringUtils.trimNull(maxWait,"60000")));
        druidDataSource.setMinIdle(Integer.parseInt(StringUtils.trimNull(minIdle, "1")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(StringUtils.trimNull(timeBetweenEvictionRunsMillis,"3000")));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(StringUtils.trimNull(minEvictableIdleTimeMillis,"300000")));
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(StringUtils.trimNull(testWhileIdle,"true")));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(StringUtils.trimNull(testOnBorrow,"false")));
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(StringUtils.trimNull(testOnReturn,"false")));
        druidDataSource.setRemoveAbandoned(Boolean.parseBoolean(StringUtils.trimNull(removeAbandoned,"true")));
        druidDataSource.setRemoveAbandonedTimeout(Integer.parseInt(StringUtils.trimNull(removeAbandonedTimeout,"180")));
        return druidDataSource;
    }

}

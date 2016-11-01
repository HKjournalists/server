package com.software.server.redis;

import com.software.server.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.util.ArrayList;
import java.util.List;


@Configuration
@PropertySources({@PropertySource("classpath:config/redis.properties")})
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.maxIdle}")
    private String maxIdle;
    @Value("${redis.maxWait}")
    private String maxWait;
    @Value("${redis.testOnBorrow}")
    private String testOnBorrow;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        PropertySourcesPlaceholderConfigurer propertyConfig = new PropertySourcesPlaceholderConfigurer();
        propertyConfig.setIgnoreResourceNotFound(true);
        propertyConfig.setOrder(3);
        return propertyConfig;
    }


    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(StringUtils.trimNull(host));
        connectionFactory.setPort(Integer.parseInt(StringUtils.trimNull(port,"6379")));
        connectionFactory.setPassword(StringUtils.trimNull(password));
        connectionFactory.setPoolConfig(jedisPoolConfig());
        return connectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(StringUtils.trimNull(maxIdle,"300")));
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(StringUtils.trimNull(maxWait,"1000")));
        jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(StringUtils.trimNull(testOnBorrow,"true")));
        return jedisPoolConfig;
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

    @Bean(initMethod = "refresh")
    public AtomRedisPool atomRedisPool(){
        AtomRedisPool atomRedisPool = new AtomRedisPool();
        atomRedisPool.setConfigPool(jedisPoolConfig());
        atomRedisPool.setSharded(jedisShardInfos());
        return atomRedisPool;
    }

    @Bean
    public List<JedisShardInfo> jedisShardInfos(){
        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        list.add(new JedisShardInfo(host,port));
        return list;
    }

    @Bean
    public RedisShardingClient redisShardingClient(){
        RedisShardingClient client = new RedisShardingClient();
        client.setAtomRedisPool(atomRedisPool());
        return client;
    }

}

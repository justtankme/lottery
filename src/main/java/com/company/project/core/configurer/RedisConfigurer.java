package com.company.project.core.configurer;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CachingConfigurerSupport;

import com.company.project.core.filter.TokenFilter;

/**  
* @ClassName: RedisConfigurer  
* @Description: redis配置
* @author duanzhiwei
* @date 2018年1月16日 上午11:49:34  
*    
*/
//@Configuration
//@EnableCaching
public class RedisConfigurer extends CachingConfigurerSupport {
    protected static Logger logger = Logger.getLogger(TokenFilter.class);

//    @Bean
//    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
//        RedisCacheManager manager = new RedisCacheManager(redisTemplate);
//        return manager;
//    }
//
//    @Bean
//    public StringRedisTemplate redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
////        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
////        ObjectMapper om = new ObjectMapper();
////        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
////        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
////        jackson2JsonRedisSerializer.setObjectMapper(om);
////        template.setValueSerializer(jackson2JsonRedisSerializer);
////        template.afterPropertiesSet();
//        return template;
//    }
//
//    @Bean
//    public JSONValueOperation valueOperation(StringRedisTemplate redisTemplate) {
//        JSONValueOperation jsonValueOperation =  new JSONValueOperation();
//        jsonValueOperation.setRedisTemplate(redisTemplate);
//        return jsonValueOperation;
//    }
//    
//    @Bean
//    public KeyGenerator smpkeyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            //执行方法所在的类  
//            sb.append(target.getClass().getSimpleName()).append(":");
//            sb.append(Stream.of(params).map(String::valueOf).collect(Collectors.joining("_")));
//            return sb.toString();
//        };
//    }
}
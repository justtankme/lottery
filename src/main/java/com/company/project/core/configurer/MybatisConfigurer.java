package com.company.project.core.configurer;

import static com.company.project.core.common.ProjectConstant.MAPPER_INTERFACE_REFERENCE;
import static com.company.project.core.common.ProjectConstant.MAPPER_PACKAGE;
import static com.company.project.core.common.ProjectConstant.MODEL_PACKAGE;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.company.project.core.common.DataSourceType;
import com.github.pagehelper.PageHelper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * 
* @ClassName: MybatisConfigurer  
* @Description: Mybatis & Mapper & PageHelper 配置
* @author duanzhiwei
* @date 2018年1月16日 上午11:47:01  
*
 */
@Configuration
@AutoConfigureAfter(DataBaseConfigurer.class)
public class MybatisConfigurer{
    private static final Logger logger = LoggerFactory.getLogger(MybatisConfigurer.class);
    
    /**  
    * @Title: sqlSessionFactoryBean  
    * @Description: SqlSessionFactoryBean、xml扫描、分页插件配置
    * @param @param dataSource
    * @param @return
    * @param @throws Exception    参数
    * @return SqlSessionFactory    返回类型  
    * @throws  
    */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("roundRobinDataSouceProxy")AbstractRoutingDataSource roundRobinDataSouceProxy) throws Exception {
        logger.info("--------------------  sqlSessionFactory init ---------------------");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(roundRobinDataSouceProxy);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");
        //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");
        //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper
//                ,new SqlPrintInterceptor()
                });

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

    /**  
    * TODO
    * @Title: sqlSessionTemplate  
    * @param @param sqlSessionFactory
    * @param @return    参数
    * @return SqlSessionTemplate    返回类型  
    * @throws  
    */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    /**  
    * @Title: mapperScannerConfigurer  
    * @Description: 配置dao接口扫描、通用Mapper属性
    * @param @return    参数
    * @return MapperScannerConfigurer    返回类型  
    * @throws  
    */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        //insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("notEmpty", "false"); 
        properties.setProperty("IDENTITY", "MYSQL");
//        properties.setProperty("IDENTITY","SELECT REPLACE(UUID(),''-'','''')");  
        //主键UUID回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)  
//        properties.setProperty("ORDER","BEFORE");  
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
    
    /**
     * 
    * 把所有数据库都放在路由中
    * @Title: roundRobinDataSouceProxy  
    * @param @param dataSourceWrite
    * @param @param dataSourceRead
    * @param @return    参数
    * @return AbstractRoutingDataSource    返回类型  
    * @throws
     */
    @Bean(name="roundRobinDataSouceProxy")
    public AbstractRoutingDataSource roundRobinDataSouceProxy(
            @Qualifier("dataSourceWrite") DruidDataSource dataSourceWrite,
            @Qualifier("dataSourceRead") DruidDataSource dataSourceRead) {
        
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        //把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一致，
        //否则切换数据源时找不到正确的数据源
        targetDataSources.put(DataSourceType.write.getType(), dataSourceWrite);
        targetDataSources.put(DataSourceType.read.getType(), dataSourceRead);
        //路由类，寻找对应的数据源
        AbstractRoutingDataSource proxy = new RoundRobinRoutingDataSouce(1);

        proxy.setDefaultTargetDataSource(dataSourceWrite);//默认库
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    /**  
    * 事务管理
    * @Title: txManager  
    * @param @param dataSource
    * @param @return    参数
    * @return PlatformTransactionManager    返回类型  
    * @throws  
    */
    @Bean
    public PlatformTransactionManager txManager(@Qualifier("roundRobinDataSouceProxy")DataSource dataSource) {
      return new DataSourceTransactionManager(dataSource);
  }
}


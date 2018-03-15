package com.company.project;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
* @ClassName: Application  
* @Description: 应用主类
* @author duanzhiwei
* @date 2018年1月16日 下午12:02:56  
*    
*/
@SpringBootApplication
@EnableTransactionManagement(order = 10)
@EnableJms
public class Application {

	@Value("${lottery.mq}")
	private String lotteryMQ;
	@Bean
    public Queue queue() {
        return new ActiveMQQueue(lotteryMQ);
    }
    //	@Value("${token.filter.unauthurl}")
    //	private String unAuthUrl;
    //	@Autowired
    //	private TokenService tokenService;
    //	@Bean
    //    public FilterRegistrationBean tokenFilterRegist() {
    //        FilterRegistrationBean registration = new FilterRegistrationBean();
    //        registration.setFilter(new TokenFilter(unAuthUrl, tokenService));
    //        registration.addUrlPatterns("/*");
    //        registration.setOrder(3);
    //        return registration;
    //    }

    public static void main(String[] args) {
    		SpringApplication.run(Application.class, args);
    }
}

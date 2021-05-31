package cn.sf.eurekaclient.config;

import cn.sf.eurekaclient.interceptor.CnsfLoadBalancerInterceptor;
import cn.sf.eurekaclient.interceptor.CustomRequestInterceptor;
import cn.sf.eurekaclient.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfiguration {

    /**
     * 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private LoadBalancerRequestFactory requestFactory;

    @Bean
    public CnsfLoadBalancerInterceptor cnsfLoadBalancerInterceptor() {
        return new CnsfLoadBalancerInterceptor(loadBalancer, requestFactory);
    }

    @Bean
    public CustomRequestInterceptor customRequestInterceptor() {
        return new CustomRequestInterceptor();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(100, TimeUnit.MILLISECONDS, 50, TimeUnit.MILLISECONDS, true);
    }
}
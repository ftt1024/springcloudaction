package cn.sf.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
// 使用feign
@EnableFeignClients(basePackages = {"cn.sf.userapi","cn.sf.eurekaclient"})
// 引入依赖类
// 方式一：@ComponentScan(basePackages = {"cn.sf.userapi.service","cn.sf.eurekaclient.service"})
// 方式二：
@Import(cn.sf.userapi.service.UserServiceFallbackFactory.class)
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}

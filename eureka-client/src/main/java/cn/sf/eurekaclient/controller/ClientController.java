package cn.sf.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;*/

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id) {
        log.info("User id is:{}", id);
        /* // 服务提供者列表
        List<ServiceInstance> serviceList = discoveryClient.getInstances("user-service");
        log.info("Instance info:{}", serviceList);
        Assert.state(serviceList != null && serviceList.size() > 0, "ServiceList invalid" + serviceList);
        // 选择一个提供者
        ServiceInstance instance = loadBalancer.choose("user-service");
        log.info("loadBalancer choose: {}", instance);*/
        return restTemplate.getForObject("http://user-service:8012/api/user/get/" + id, String.class);
    }
}

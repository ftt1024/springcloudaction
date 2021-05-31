package cn.sf.eurekaclient.service;

import cn.sf.eurekaclient.config.FeignConfiguration;
import cn.sf.eurekaclient.entity.customer.CustomerParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * customer api
 * feign本地配置方式
 */
@FeignClient(value = "customer-service", configuration = FeignConfiguration.class, fallbackFactory = CustomerServiceFallbackFactory.class)
public interface CustomerService {

    @GetMapping("/api/customer/getByNo")
    String getByNo(@RequestParam String customerNo);

    @GetMapping("/api/customer/get/{customerNo}")
    String get(@PathVariable String customerNo);

    @GetMapping("/api/customer/getByParam")
        // String getByParam(@RequestParam String name, @RequestParam  Integer gender);
    String getByParam(@SpringQueryMap CustomerParam param);

    @PostMapping("/api/customer/add")
    String add(@RequestBody CustomerParam param);

}

package cn.sf.eurekaclient.controller;

import cn.sf.eurekaclient.entity.customer.CustomerParam;
import cn.sf.eurekaclient.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/feign/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get")
    public Object get(CustomerParam param) {
        log.info("Get param:{}", param);
        return customerService.getByParam(param);
    }

    @GetMapping("/get/{customerNo}")
    public Object get(@PathVariable String customerNo) {
        log.info("Get param:{}", customerNo);
        return customerService.get(customerNo);
    }

    @PostMapping("/add")
    public Object add(CustomerParam param) {
        log.info("Add param:{}", param);
        return customerService.add(param);
    }
}

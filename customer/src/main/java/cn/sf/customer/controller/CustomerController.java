package cn.sf.customer.controller;

import cn.sf.customer.entity.CustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/getByNo")
    public Object getByNo(@RequestParam String customerNo) {
        log.info("customerNo: {}", customerNo);
        return customerNo;
    }

    @GetMapping("/get/{customerNo}")
    public Object get(@PathVariable String customerNo) {
        log.info("customerNo: {}", customerNo);
        return customerNo;
    }

    @GetMapping("/getByParam")
    public Object get(CustomerRequest param) {
        log.info("param: {}", param);
        return param;
    }

    @PostMapping("/add")
    public Object add(@RequestBody CustomerRequest param) {
        log.info("Add customer: {}", param);
        return param;
    }

}

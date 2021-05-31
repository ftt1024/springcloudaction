package cn.sf.eurekaclient.service;

import cn.sf.common.constant.Tips;
import cn.sf.common.util.JsonUtil;
import cn.sf.eurekaclient.entity.customer.CustomerParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 使用sentinel进行服务降级、熔断
 * （或者hystrix）
 */
@Slf4j
@Component
public class CustomerServiceFallbackFactory implements FallbackFactory<CustomerService> {

    @Override
    public CustomerService create(Throwable cause) {
        return new CustomerService() {
            @Override
            public String getByNo(String customerNo) {
                log.info("FallbackFactory customerNo:{}", customerNo);
                return Tips.SERVICE_NOT_AVAILABLE;
            }

            @Override
            public String get(String customerNo) {
                log.info("FallbackFactory customerNo:{}", customerNo);
                return Tips.SERVICE_NOT_AVAILABLE;
            }

            @Override
            public String getByParam(CustomerParam param) {
                log.info("FallbackFactory param:{}", JsonUtil.toJson(param));
                return Tips.SERVICE_NOT_AVAILABLE;
            }

            @Override
            public String add(CustomerParam param) {
                log.info("FallbackFactory param:{}", JsonUtil.toJson(param));
                return Tips.SERVICE_NOT_AVAILABLE;
            }
        };
    }
}

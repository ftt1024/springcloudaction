package cn.sf.gateway;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
//@NacosPropertySource(dataId = "${nacos.config.data-id}", autoRefreshed = true)
@SpringBootApplication
public class GatewayNacosApplication {
    // 添加监听器
    //    @Autowired
    //    private NacosGatewayDefineConfig nacosGatewayDefineConfig;
    //    @PostConstruct
    //    public void addListener() {
    //        // Nacos
    //        nacosGatewayDefineConfig.addRouteNacosListen();
    //    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayNacosApplication.class, args);
        log.info("Gateway started!");
    }
}

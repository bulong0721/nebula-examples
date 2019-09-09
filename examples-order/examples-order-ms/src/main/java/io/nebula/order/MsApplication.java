package io.nebula.order;

import io.nebula.core.annotation.EnableFramework;
import io.nebula.kernel.configuration.OpenFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nebula-archetype
 * @version 1.0-SNAPSHOT
 * @date 2018/12/15
 */
@EnableFramework
@EnableDiscoveryClient
@EnableFeignClients(value = "io.nebula", defaultConfiguration = OpenFeign.class)
@ComponentScan(value = "io.nebula")
public class MsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsApplication.class);
    }
}

package io.nebula.examples;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nebula.core.annotation.EnableFramework;
import io.nebula.examples.model.WaybillNoVersion;
import io.nebula.examples.producer.StudentProducer;
import io.nebula.kernel.configuration.OpenFeign;
import io.nebula.messaging.annotation.EnableMQ;
import io.nebula.examples.producer.WaybillProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author nebula-archetype
 * @version 1.0-SNAPSHOT
 * @date ${date}
 */
@EnableFramework
@EnableMQ(consumeOn = true)
@EnableDiscoveryClient
@EnableFeignClients(value = "io.nebula", defaultConfiguration = OpenFeign.class)
@ComponentScan(value = "io.nebula")
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Autowired(required = false)
            private StudentProducer studentProducer;
            @Autowired(required = false)
            private WaybillProducer waybillProducer;
            private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            @Override
            public void run(String... args) throws Exception {
                scheduler.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
//                        if (null != studentProducer) {
//                            Student student = new Student();
//                            student.setName("nebula");
//                            student.setAge(System.currentTimeMillis());
//                            studentProducer.send(student);
//                        }
                        WaybillNoVersion waybill = new WaybillNoVersion();
                        waybill.setWaybillNo(System.currentTimeMillis());
                        waybill.setColumn2("nebula-producer");
                        waybill.setApplyId(123L);

                        try {
                            waybillProducer.send(waybillProducer.wrapper(waybill));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }, 0, 3, TimeUnit.SECONDS);
            }
        };
    }
}

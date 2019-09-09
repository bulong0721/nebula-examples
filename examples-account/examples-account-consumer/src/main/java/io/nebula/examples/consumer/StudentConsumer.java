package io.nebula.examples.consumer;

import io.nebula.examples.model.Student;
import io.nebula.messaging.annotation.Consumer;
import io.nebula.messaging.api.Headers;
import io.nebula.messaging.api.MessageListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/14
 */
@Slf4j
//@Component
@Consumer(topic = "student")
//@ConfigurationProperties("nebula.messaging.mq1")
public class StudentConsumer extends MessageListener<Student> {

    @Override
    public void onMessage(Headers headers, Student student) throws Exception {
        log.info("receive message: {}", student);
    }
}

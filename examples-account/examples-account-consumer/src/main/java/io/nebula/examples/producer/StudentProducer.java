package io.nebula.examples.producer;

import io.nebula.examples.model.Student;
import io.nebula.messaging.annotation.Producer;
import io.nebula.messaging.api.MessageSender;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/14
 */
@Producer(topic = "student")
public interface StudentProducer extends MessageSender<Student> {
}

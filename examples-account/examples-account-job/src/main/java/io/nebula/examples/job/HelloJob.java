package io.nebula.examples.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import io.nebula.examples.producer.StudentProducer;
import io.nebula.schedule.annotation.Schedule;
import io.nebula.time.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author nebula-archetype
 * @version 1.0-SNAPSHOT
 * @date ${date}
 */
@Slf4j
@Schedule(name = "helloJob", cron = "0/5 * * * * ?")
public class HelloJob implements SimpleJob {

    @Autowired
    private StudentProducer producer;

    @Override
    public void execute(ShardingContext shardingContext) {
//        Student student = new Student();
//        student.setName("elastic-job");
//        student.setAge(System.currentTimeMillis());
//        producer.send(student);
        System.out.println("Hello world: " + DateUtil.formatDateTime(new Date()));
    }
}

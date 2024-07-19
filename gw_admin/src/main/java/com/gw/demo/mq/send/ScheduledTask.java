package com.gw.demo.mq.send;

import com.gw.demo.mq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class ScheduledTask {

    private final Producer producer;

    @Autowired
    public ScheduledTask(Producer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 60000)
    public void sendWarningMessage() {
        producer.send();
    }
}

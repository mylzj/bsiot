package bsiotmobile.mobile.test;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/5/3 13:28
 */
@Service
public class MqService {

    @RabbitListener(queues = "rose.news")
    public void reciveMQ(Object object){
        System.out.println(object);
    }
}

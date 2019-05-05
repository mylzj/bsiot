package bsiotmobile.mobile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MobileApplicationTests {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        Map<String,String> map=new HashMap<>();
        map.put("new1","篮球队");
        map.put("new2","赢了");
        rabbitTemplate.convertAndSend("rose.direct","rose.news",map);
    }

    @Test
    public void reciveRabbitMq(){
        Object o = rabbitTemplate.receiveAndConvert("rose.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}


package bsiotmobile.mobile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bsiotmobile.mobile.mapper")
@EnableRabbit
public class MobileApplication {

    public static void main(String[] args) {

        SpringApplication.run(MobileApplication.class, args);

    }

}


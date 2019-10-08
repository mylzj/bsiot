package bsiotmobile.mobile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("bsiotmobile.mobile.mapper")
@EnableRabbit
public class MobileApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    public static void main(String[] args) {

        SpringApplication.run(MobileApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource.getConnection().toString());
    }
}


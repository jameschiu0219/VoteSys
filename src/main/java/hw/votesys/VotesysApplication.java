package hw.votesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotesysApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotesysApplication.class, args);
        System.out.println("Spring Boot 啟動完成");
    }

}

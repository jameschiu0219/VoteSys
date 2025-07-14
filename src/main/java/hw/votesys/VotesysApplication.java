package hw.votesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VotesysApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotesysApplication.class, args);
        //System.out.println(new BCryptPasswordEncoder().encode("111"));    //手動加密密碼
        System.out.println("Spring Boot 啟動完成");
    }

}

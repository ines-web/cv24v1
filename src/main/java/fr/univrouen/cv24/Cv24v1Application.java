package fr.univrouen.cv24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = { "fr.univrouen.cv24.model" })
@EnableTransactionManagement
public class Cv24v1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cv24v1Application.class, args);
    }

}
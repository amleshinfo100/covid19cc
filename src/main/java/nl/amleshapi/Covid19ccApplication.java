package nl.amleshapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class Covid19ccApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ccApplication.class, args);
	}

}

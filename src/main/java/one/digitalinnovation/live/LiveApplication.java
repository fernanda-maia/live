package one.digitalinnovation.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiveApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiveApplication.class, args);
		System.out.println("Hello, Gradle!");
	}

}

package elisko.laba2;

import elisko.laba2.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Laba2Application {

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext context =SpringApplication.run(Laba2Application.class, args);
		TestService testService = context.getBean(TestService.class);
		testService.test();
	}

}

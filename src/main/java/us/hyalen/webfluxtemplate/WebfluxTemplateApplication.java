package us.hyalen.webfluxtemplate;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class WebfluxTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxTemplateApplication.class, args);
	}

	@PostConstruct
	private void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}

package com.madeeasy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Student Service",
				version = "1.0",
				description = "Student Service",
				contact = @Contact(
						email = "pabitrabera2001@gmail.com",
						name = "Pabitra Bera",
						url = "https://www.linkedin.com/in/pabitra-bera"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://demo.org/licenses/LICENSE-2.0"
				),
				termsOfService = "T&C",
				summary = "Manage Student information"
		)
)
@EnableAspectJAutoProxy
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

}

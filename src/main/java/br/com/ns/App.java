package br.com.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Main principal para execução de Spring-Boot utilizando um embeded Tomcat
 * 
 * @author Rodrigo Braga
 * 
 *         Documentação spring boot:
 *         http://docs.spring.io/spring-boot/docs/1.2.3
 *         .RELEASE/reference/htmlsingle/
 *
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

}

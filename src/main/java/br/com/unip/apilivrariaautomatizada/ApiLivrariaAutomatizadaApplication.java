package br.com.unip.apilivrariaautomatizada;

import br.com.unip.apilivrariaautomatizada.config.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({CorsProperties.class})
public class ApiLivrariaAutomatizadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLivrariaAutomatizadaApplication.class, args);
	}


}

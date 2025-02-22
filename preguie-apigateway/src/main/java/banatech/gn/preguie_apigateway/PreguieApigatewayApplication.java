package banatech.gn.preguie_apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PreguieApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreguieApigatewayApplication.class, args);
	}

}

package com.github.albertloubet.pixmanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        version = "1.0.0",
        title = "Pix Manager API",
        description = "Microservice that manipulates Pix operations",
        contact = @Contact(name = "Albert Loubet do Nascimento", url = "https://github.com/albertloubet")
))
public class PixManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PixManagerApplication.class, args);
    }
}
package com.bridgecare.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EntityScan("com.bridgecare.common.models.entities")
public class MainApplication {

    static {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
        System.setProperty("SSL_ALIAS", dotenv.get("SSL_ALIAS"));
        System.setProperty("SSL_ALIAS", dotenv.get("SSL_PASSWORD"));
        System.setProperty("SSL_ALIAS", dotenv.get("SSL_STORE_PASSWORD"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

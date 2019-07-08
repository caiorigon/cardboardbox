package com.logic.cardboardbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class CardboardboxApplication {

    private static final Logger log = LoggerFactory.getLogger(CardboardboxApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CardboardboxApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();

        log.info("\n\n\t---------------------------------------------\n\t" +
                "=======Cardboardbox inicializado na porta: " + environment.getProperty("server.port") + "=========" +
                "\n\t---------------------------------------------\n\t");
    }
}

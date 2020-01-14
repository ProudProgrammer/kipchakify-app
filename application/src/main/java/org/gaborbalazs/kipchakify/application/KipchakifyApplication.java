package org.gaborbalazs.kipchakify.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gaborbalazs.kipchakify"})
public class KipchakifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KipchakifyApplication.class, args);
    }

}

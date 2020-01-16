package org.gaborbalazs.kipchakifyapp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gaborbalazs.kipchakifyapp"})
public class KipchakifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KipchakifyApplication.class, args);
    }

}

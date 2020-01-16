package org.gaborbalazs.kipchakifyapp.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.gaborbalazs.kipchakify.KipchakifyProvider;
import org.gaborbalazs.kipchakify.KipchakifyService;
import org.gaborbalazs.kipchakify.KipchakifyServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KipchakifyConfiguration {

    @Value("${kipchakify.provider.class:#{null}}")
    private String kipchakifyProviderClass;

    @Autowired
    private KipchakifyProvider kipchakifyProvider;

    @Autowired
    private KipchakifyServiceFactory kipchakifyServiceFactory;

    @Bean
    KipchakifyProvider kipchakifyProvider() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends KipchakifyProvider> clazz = (Class<? extends KipchakifyProvider>) Class.forName(kipchakifyProviderClass);
        Constructor<? extends KipchakifyProvider> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    @Bean
    KipchakifyServiceFactory kipchakifyServiceFactory() {
        return kipchakifyProvider.createKipchakifyServiceFactory();
    }

    @Bean
    KipchakifyService kipchakifyService() {
        return kipchakifyServiceFactory.createKipchakifyService();
    }
}

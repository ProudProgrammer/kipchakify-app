package org.gaborbalazs.kipchakifyapp.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.gaborbalazs.kipchakify.KipchakifyProvider;
import org.gaborbalazs.kipchakify.KipchakifyService;
import org.gaborbalazs.kipchakify.KipchakifyServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KipchakifyConfiguration {

    @Bean
    KipchakifyProvider kipchakifyProvider(@Value("${kipchakify.provider.class:#{null}}") String kipchakifyProviderClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (kipchakifyProviderClass == null) {
            throw new IllegalArgumentException("Need to specify fully qualified class name for KipchakifyProvider implementation as a property named: kipchakify.provider.class");
        }
        Class<? extends KipchakifyProvider> clazz = (Class<? extends KipchakifyProvider>) Class.forName(kipchakifyProviderClass);
        Constructor<? extends KipchakifyProvider> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    @Bean
    KipchakifyServiceFactory kipchakifyServiceFactory(KipchakifyProvider kipchakifyProvider) {
        return kipchakifyProvider.createKipchakifyServiceFactory();
    }

    @Bean
    KipchakifyService kipchakifyService(KipchakifyServiceFactory kipchakifyServiceFactory) {
        return kipchakifyServiceFactory.createKipchakifyService();
    }
}

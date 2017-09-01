package com.thomascook;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySources({
        @PropertySource(value={"classpath:config.properties"}),
        @PropertySource(value={"classpath:credentials.properties"})
})
@ComponentScan
public class Context {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Profile("staging")
    public static PropertySourcesPlaceholderConfigurer stagingProperties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application-staging.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    @Profile("prod")
    public static PropertySourcesPlaceholderConfigurer prodProperties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application-prod.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

}

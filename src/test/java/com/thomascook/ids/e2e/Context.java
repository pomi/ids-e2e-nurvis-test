package com.thomascook.ids.e2e;

import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Properties;

@Configuration
@PropertySource(value="classpath:my.properties")
public class Context {
    public static class Holder{

        OTAPkgSearchRS otaPkgSearchRS;
        String placeholder;
        static Properties properties;

        public OTAPkgSearchRS getOtaPkgSearchRS() {
            return otaPkgSearchRS;
        }

        public void setOtaPkgSearchRS(OTAPkgSearchRS otaPkgSearchRS) {
            this.otaPkgSearchRS = otaPkgSearchRS;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }

    @Bean
    public Holder holder() {
        return new Holder();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}

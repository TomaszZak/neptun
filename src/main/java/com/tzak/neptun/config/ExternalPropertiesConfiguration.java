package com.tzak.neptun.config;


import com.sun.javafx.runtime.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@PropertySource("file:${user.dir}/config/external.properties")
public class ExternalPropertiesConfiguration {


    @Value("${external.properties.info}")
    private String externalPropertiesInfo;

    @Autowired
    private Environment env;

    public Properties getExternalProperties() {
        return null;  //TODO zwrócić obiekt propertisów - pytanie czy dodać jako obiekt w Beanie
    }

    public List<String> getDefaultApplicationPaths() {
        List<String> paths = new ArrayList<>();
        paths.add("user.dir: " + System.getProperty("user.dir"));
        paths.add("user.home: " + System.getProperty("user.home"));

        return paths;
    }

    public String getExternalPropertiesInfo() {
        return externalPropertiesInfo;
    }
}


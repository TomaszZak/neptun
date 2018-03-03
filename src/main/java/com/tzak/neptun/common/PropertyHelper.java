package com.tzak.neptun.common;

import com.tzak.neptun.config.ExternalPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PropertyHelper {

    // propertka z domyślnego application.properties
    @Value("${welcome.page.message}")
    private String welcomePageMessage;

    //propertki z zewnętrznego config/external.properties
    @Autowired
    private ExternalPropertiesConfiguration externalPropertiesConfiguration;

    public String testExternalProperties() {
        String externalPropertiesInfo = externalPropertiesConfiguration.getExternalPropertiesInfo();
        System.out.println(PropertyHelper.class.getSimpleName() + " -> " +  externalPropertiesInfo);
        return externalPropertiesInfo;
    }

    public String testApplicationProperties() {
        System.out.println(PropertyHelper.class.getSimpleName() + " -> " +  welcomePageMessage);
        return welcomePageMessage;
    }


}

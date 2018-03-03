package com.tzak.neptun.config;

import com.tzak.neptun.common.DatabaseHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class DatabaseConfiguration {

    @Value("${db.file.name}")
    private String dbFileName;

    @Value("${db.file.path}")
    private String dbFilePath;


    @PostConstruct
    public void init() throws Exception {
        //TODO zrobić loggera
        System.out.println("=== " + DatabaseConfiguration.class.getSimpleName() +
                " Init method PostConstruct DatabaseConfiguration");
        DatabaseHelper.createNewDatabase(dbFilePath, dbFileName);
    }

/*    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }*/
}

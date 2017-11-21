package eu.openminted.content.rest.service;

import eu.openminted.content.connector.ContentConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static Logger log = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    ContentConnector contentConnector;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("OpenMinTeD REST Service started...");
        log.info("Active content connector: " + contentConnector.toString());
    }
}

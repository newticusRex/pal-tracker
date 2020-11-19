package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

// What are the Spring Boot Features
//  -   Handles the cration of boiler-plate code
//  -   Auto configuration
//  -   Dependency management
//  -   Fat jar (built in web-container)
//  -   Introduce annotation functionality
//      -   Scans classes for beans (classes)

@SpringBootApplication
public class PalTrackerApplication {

    private DataSource dataSource;

    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);
    }
    public PalTrackerApplication(DataSource datasource){
        this.dataSource = datasource;
    }

    @Bean
    TimeEntryRepository timeEntryRepository(){
        return new JdbcTimeEntryRepository( dataSource );
    }
}

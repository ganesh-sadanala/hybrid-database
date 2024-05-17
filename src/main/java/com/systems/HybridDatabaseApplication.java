package com.systems;

import com.systems.service.DataTieringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class HybridDatabaseApplication {

    @Autowired
    private DataTieringService dataTieringService;

    public static void main(String[] args) {
        SpringApplication.run(HybridDatabaseApplication.class, args);
    }

    @Scheduled(fixedRate = 60000) // Run every minute
    public void tierData() {
        dataTieringService.analyzeAndMoveData();
    }
}

package com.example.demo.config;

import com.dewdrop.Dewdrop;
import com.dewdrop.config.DewdropProperties;
import com.dewdrop.config.DewdropSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DewdropConfig {

    @Bean
    public Dewdrop dewdrop() {
        DewdropProperties properties = DewdropProperties.builder()
            .packageToScan("com.example.demo")
            .connectionString("esdb://localhost:2113?tls=false")
            .create();

        return DewdropSettings.builder()
            .properties(properties)
            .create()
            .start();
    }
}

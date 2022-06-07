package com.example.demo.config;

import com.dewdrop.Dewdrop;
import com.dewdrop.config.DewdropProperties;
import com.dewdrop.config.DewdropSettings;

public class DewdropConfig {
    private static Dewdrop instance = null;

    public static Dewdrop getInstance() {
        DewdropProperties properties = DewdropProperties.builder().packageToScan("com.example.demo").connectionString("esdb://localhost:2113?tls=false").create();

        if (instance == null) {
            instance = DewdropSettings.builder().properties(properties).create().start();
        }

        return instance;
    }

}

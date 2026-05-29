package com.parking.infrastructure.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.project-id}")
    private String projectId;

    @PostConstruct
    public void initialize() {

        try {

            if (FirebaseApp.getApps().isEmpty()) {

                FirebaseOptions options =
                        FirebaseOptions.builder()
                                .setCredentials(
                                        GoogleCredentials
                                                .getApplicationDefault()
                                )
                                .setProjectId(projectId)
                                .build();

                FirebaseApp.initializeApp(options);

                System.out.println(
                        "Firebase inicializado correctamente"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
package com.parking.infrastructure.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class FirebaseAdminConfig {

    @Value("${firebase.project-id:project-7bd198ee-ecbf-4324-bd0}")
    private String projectId;

    @PostConstruct
    public void initFirebase() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setProjectId(projectId)   // ← agrega esta línea
                    .build();
            FirebaseApp.initializeApp(options);
        }
    }
}
package com.parking.infrastructure.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticación", description = "Verificación de CAPTCHA")
public class CaptchaController {

    @Value("${recaptcha.secret-key:}")
    private String secretKey;

    private static final String VERIFY_URL =
        "https://www.google.com/recaptcha/api/siteverify";

    @Operation(
        summary = "Verificar CAPTCHA",
        description = "Verifica el token de reCAPTCHA v3. Score mínimo: 0.5"
    )
    @PostMapping("/captcha")
    public ResponseEntity<Map<String, Object>> verifyCaptcha(
            @RequestBody Map<String, String> body) {

        String token = body.get("token");
        String url   = VERIFY_URL + "?secret=" + secretKey
                     + "&response=" + token;

        RestTemplate restTemplate = new RestTemplate();
        Map<?, ?> response = restTemplate.postForObject(
                url, null, Map.class);

        boolean success = Boolean.TRUE.equals(response.get("success"));
        double  score   = response.get("score") != null
                ? ((Number) response.get("score")).doubleValue()
                : 0.0;

        boolean valid = success && score >= 0.5;

        return ResponseEntity.ok(Map.of(
                "success", valid,
                "score",   score
        ));
    }
}
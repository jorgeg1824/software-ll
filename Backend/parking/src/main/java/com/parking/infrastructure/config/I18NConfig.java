package com.parking.infrastructure.config;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class I18NConfig {

    private static final Locale SPANISH = Locale.of("es");

    @Bean
    public LocaleResolver localeResolver() {

        AcceptHeaderLocaleResolver resolver =
                new AcceptHeaderLocaleResolver();

        resolver.setSupportedLocales(List.of(
                SPANISH,
                Locale.ENGLISH
        ));

        resolver.setDefaultLocale(SPANISH);

        return resolver;
    }

    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource source =
                new ResourceBundleMessageSource();

        source.setBasename("messages");
        source.setDefaultEncoding(StandardCharsets.UTF_8.name());
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
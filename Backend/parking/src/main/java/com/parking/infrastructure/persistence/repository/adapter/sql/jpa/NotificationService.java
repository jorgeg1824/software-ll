package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.CatalogoNotificacionJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    private final JavaMailSender mailSender;
    private final CatalogoNotificacionJPARepository notifRepository;

    public NotificationService(
            final JavaMailSender mailSender,
            final CatalogoNotificacionJPARepository notifRepository) {
        this.mailSender      = mailSender;
        this.notifRepository = notifRepository;
    }

    @Async
    public void sendTicketNotification(
            final String recipientEmail,
            final Map<String, String> variables,
            final String lang) {

        notifRepository.findByCodigoAndActivoTrue("TICKET_INGRESO")
                .ifPresentOrElse(
                    template -> {
                        String subject = "en".equals(lang)
                                ? template.getAsuntoEn()
                                : template.getAsuntoEs();

                        String body = "en".equals(lang)
                                ? template.getCuerpoEn()
                                : template.getCuerpoEs();

                        for (Map.Entry<String, String> entry : variables.entrySet()) {
                            String placeholder = "{" + entry.getKey() + "}";
                            body    = body.replace(placeholder, entry.getValue());
                            if (subject != null) {
                                subject = subject.replace(placeholder, entry.getValue());
                            }
                        }

                        try {
                            SimpleMailMessage message = new SimpleMailMessage();
                            message.setTo(recipientEmail);
                            message.setSubject(subject);
                            message.setText(body);
                            mailSender.send(message);
                            log.info("Notificación enviada a: {}", recipientEmail);
                        } catch (Exception e) {
                            log.error("Error enviando notificación a {}: {}",
                                    recipientEmail, e.getMessage());
                        }
                    },
                    () -> log.warn("Plantilla TICKET_INGRESO no encontrada en el catálogo")
                );
    }
}
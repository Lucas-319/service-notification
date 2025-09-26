package br.com.lucas.service.notification.controller;

import br.com.lucas.service.notification.util.NotificationRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final JavaMailSender mailSender;

    public NotificationController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println(notificationRequest.message());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notificationRequest.email());
        message.setSubject("Notification");
        message.setText(notificationRequest.message());
        mailSender.send(message);
    }
}

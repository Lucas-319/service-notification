package br.com.lucas.service.notification.controller;

import br.com.lucas.service.notification.util.NotificationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println(notificationRequest.message());
    }
}

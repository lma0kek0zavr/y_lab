package io.ylab.service;

/**
 * Интерфейс сервиса для отправки уведомлений
 */
public interface NotificationService {
    String sendNotification(String message);
    String subscribe(int id);
}

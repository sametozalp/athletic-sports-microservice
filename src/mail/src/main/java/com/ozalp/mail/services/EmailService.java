package com.ozalp.mail.services;

public interface EmailService {

    void sendMail(String to, String subject, String body);
}

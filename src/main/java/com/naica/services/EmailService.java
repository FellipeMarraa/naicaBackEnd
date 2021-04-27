package com.naica.services;



import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;




public interface EmailService {

    void sendOrderConfirmationEmail(Coordenador obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Coordenador obj);

    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Coordenador coordenador, String newPass);
}

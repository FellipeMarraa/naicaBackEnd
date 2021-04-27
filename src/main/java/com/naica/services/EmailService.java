package com.naica.services;



import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.naica.domain.Coordenador;




public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Coordenador obj);

    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Coordenador coordenador, String newPass);

	void sendOrderConfirmationEmail(Coordenador coordenador);
}

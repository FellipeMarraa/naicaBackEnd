package com.naica.services;



import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.naica.domain.Coordenador;


public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendOrderConfirmationEmail(Coordenador coordenador) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromResponsavel(coordenador);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromResponsavel(Coordenador coordenador) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(coordenador.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Coordenador cadastrado! ID: " + coordenador.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(coordenador.toString());
        return sm;
    }

    protected String htmlFromTemplateResponsavel(Coordenador coordenador) {
        Context context = new Context();
        context.setVariable("responsavel", coordenador);
        return templateEngine.process("email/confirmacaoCadastro", context);
    }

    @Override
    public void sendOrderConfirmationHtmlEmail(Coordenador coordenador) {
        try {
            MimeMessage mm = prepareMimeMessageFromResponsavel(coordenador);
            sendHtmlEmail(mm);
        }
        catch (MessagingException e) {
            sendOrderConfirmationEmail(coordenador);
        }
    }

    protected MimeMessage prepareMimeMessageFromResponsavel(Coordenador coordenador) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(coordenador.getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Responsavel cadastrado! ID: " + coordenador.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateResponsavel(coordenador), true);
        return mimeMessage;
    }

    @Override
    public void sendNewPasswordEmail(Coordenador coordenador, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(coordenador, newPass);
        sendEmail(sm);
    }

    protected  SimpleMailMessage prepareNewPasswordEmail(Coordenador coordenador, String newPass){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(coordenador.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}

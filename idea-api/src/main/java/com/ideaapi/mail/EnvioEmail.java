package com.ideaapi.mail;

import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EnvioEmail {

    @Autowired
    private JavaMailSender javaMailSender;

//    @EventListener
//    private void testeEmail(ApplicationReadyEvent event) {
//
//        this.enviarEmail("openlinkti@gmail.com", Arrays.asList("alvesdesouzaalex@gmail.com"), "teste", "OI Testes");
//
//    }

    public void enviarEmail(String remetente, List<String> destinatarios, String assunto, String mensagem) {

        try {

            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setFrom(remetente);
            helper.setTo(destinatarios.toArray(new String[destinatarios.size()]));
            helper.setSubject(assunto);
            helper.setText(mensagem, true);

            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar email");
        }

    }
}

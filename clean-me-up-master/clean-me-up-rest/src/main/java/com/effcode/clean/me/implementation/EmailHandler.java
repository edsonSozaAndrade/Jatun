package com.effcode.clean.me.implementation;

import com.effcode.clean.me.interfaces.IEmailHandler;
import com.effcode.clean.me.pojo.SendMailRequest;
import com.effcode.clean.me.pojo.SendMailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.effcode.clean.me.support.SmtpEmail;
import com.effcode.clean.me.support.SmtpHandler;

@Component
public class EmailHandler implements IEmailHandler {
    
    @Autowired
    SmtpHandler smtpHandler;
    
    Logger log = LoggerFactory.getLogger(EmailHandler.class);
    
    @Override
    public SendMailResponse send(SendMailRequest request) {

        SendMailResponse response;
        LogMailContent(request);
        response = ValidateEmailData(request);

        if (response.getStatus()){
            SmtpEmail smtpEmail = new SmtpEmail();
            smtpEmail.adrs = new String[] {request.getAddress()};
            smtpEmail.content = request.getContent();
            smtpEmail.subject = request.getSubject();
            smtpEmail.password =  System.getProperty("email.password");
            smtpEmail.username = System.getProperty("email.username");;
            smtpHandler.post(smtpEmail);
            log.info("Send email. Address: " + request.getAddress() + ", Subject: " + request.getSubject());

            response.setStatus(true);
            response.setMessage("Message sent successfully");
        }
        return response;
    }

    private void LogMailContent(SendMailRequest request){
        log.debug("Address: " + request.getAddress());
        log.debug("Subject: " + request.getSubject());
        log.debug("Content: " + request.getContent());
    }

    private SendMailResponse ValidateEmailData(SendMailRequest request)
    {
        String validationErrorMessage = "";
        SendMailResponse response = new SendMailResponse();

        if(request.getSubject() == null) {
            validationErrorMessage = "Subject is null";
            log.error(validationErrorMessage);
            response.setMessage(validationErrorMessage);
            response.setStatus(false);
            return response;
        }

        if(request.getContent().length() > 65000) {
            validationErrorMessage = "Content to BIG: " + request.getContent().length();
            log.error(validationErrorMessage);
            response.setMessage(validationErrorMessage);
            response.setStatus(false);
            return response;
        }

        response.setStatus(true);

        return response;
    }
}

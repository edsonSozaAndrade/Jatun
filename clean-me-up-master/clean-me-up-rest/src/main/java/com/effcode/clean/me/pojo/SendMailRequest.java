package com.effcode.clean.me.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class SendMailRequest {

    @Email
    private String address;

    public String getAddress() {
        return address;
    }
    public void setColor(String address) {
        this.address = address;
    }

    @NotBlank
    @NotNull
    private String subject;

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @NotBlank
    @NotNull
    private String content;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
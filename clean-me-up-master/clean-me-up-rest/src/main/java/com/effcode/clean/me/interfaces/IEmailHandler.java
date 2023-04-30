package com.effcode.clean.me.interfaces;

import com.effcode.clean.me.pojo.SendMailRequest;
import com.effcode.clean.me.pojo.SendMailResponse;

public interface IEmailHandler {
    public SendMailResponse send(SendMailRequest request);
}

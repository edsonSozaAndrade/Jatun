package com.effcode.clean.me.rest;

import com.effcode.clean.me.interfaces.IEmailHandler;
import com.effcode.clean.me.pojo.SendMailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.effcode.clean.me.pojo.SendMailRequest;

@Controller
public class EmailApi {

    @Autowired
    IEmailHandler emailHandler;

    @PostMapping("/send")
    public ResponseEntity<SendMailResponse> send(@RequestBody SendMailRequest request) {
        SendMailResponse response = emailHandler.send(request);
        if (response.getStatus()) {
            return new ResponseEntity<SendMailResponse>(HttpStatus.OK);
        } else {
            return new ResponseEntity<SendMailResponse>(HttpStatus.BAD_REQUEST);
        }
    }

}

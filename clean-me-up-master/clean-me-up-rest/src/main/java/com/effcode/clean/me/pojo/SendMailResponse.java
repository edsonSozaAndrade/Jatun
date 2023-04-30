package com.effcode.clean.me.pojo;

public class SendMailResponse {
    private String message;
    private Boolean status;

    public SendMailResponse(){

    };
    public SendMailResponse(String message){
        this.message = message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

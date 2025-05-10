package com.kltn.medicalwebsite.service;

public interface EmailSenderService {


    void sendEmail(String toEmail,String subject,String body);

}

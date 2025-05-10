package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;


    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestParam("toEmail")String toEmail,@RequestParam("subject")String subject,@RequestParam("body")String body){
        emailSenderService.sendEmail(toEmail,subject,body);
        return  ResponseEntity.ok("Send email success");
    }
}

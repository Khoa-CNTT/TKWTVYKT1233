package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Client;
import com.kltn.medicalwebsite.request.ClientRequest;
import com.kltn.medicalwebsite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {



    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> clients = clientService.findALl();
        if(clients.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(clients,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public  ResponseEntity<Client> register(@RequestBody ClientRequest clientRequest){
        Client registerClient = clientService.register(clientRequest);
        return  ResponseEntity.ok(registerClient);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<String> update(@PathVariable("id") Long id ,@RequestBody ClientRequest client){
        clientService.updateClient(client,id);
        return  ResponseEntity.ok("Update Client:"+id + "Success");
    }
    @GetMapping("/search/email")
    public  ResponseEntity<Client> findClientByEmail(@RequestParam("email") String email){
        Client client  = clientService.findClientByEmail(email);
        return  new ResponseEntity<>(client,HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public  ResponseEntity<Client> findClientByEmail(@PathVariable("id") Long id){
        Client client  = clientService.findClientById(id);
        return  new ResponseEntity<>(client,HttpStatus.OK);
    }

    @GetMapping("/valid/email")
    public  ResponseEntity<?> validEmailExisting(@RequestParam("email") String email){
        List<Client> clients = clientService.findALl();
        for (Client client : clients){
            if(client.getEmail().equals(email)){
                return  new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

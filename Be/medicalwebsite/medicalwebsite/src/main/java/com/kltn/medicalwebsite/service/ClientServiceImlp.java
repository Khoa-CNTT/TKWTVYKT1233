package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Client;
import com.kltn.medicalwebsite.exception.ClientException;
import com.kltn.medicalwebsite.repository.ClientRepository;
import com.kltn.medicalwebsite.request.ClientRequest;
import com.kltn.medicalwebsite.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImlp  implements  ClientService{


    private ClientRepository repository;

    public ClientServiceImlp(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findALl() {
         return  repository.findAll();
    }

    @Override
    public Client register(ClientRequest client) {
        Client newClient = new Client();
        newClient.setEmail(client.getEmail());
        newClient.setFullName(client.getFullName());
        newClient.setPhone(client.getPhone());
        newClient.setAddress(client.getAddress());
        newClient.setPassword(client.getPassword());
        newClient.setRole("ROLE_USER");
        newClient.setCreatedAt(LocalDateTime.now());
        newClient.setClock(false);
        return repository.save(newClient);
    }

    @Override
    public void updateClient(ClientRequest client, Long id) {
        Optional<Client> existingClient = repository.findById(id);
        if(existingClient.isPresent()){
            Client updateClient = existingClient.get();
            updateClient.setFullName(client.getFullName());
            updateClient.setEmail(client.getEmail());
            updateClient.setAddress(client.getAddress());
            updateClient.setPhone(client.getPhone());
            updateClient.setRole("ROLE_USER");
            updateClient.setCreatedAt(LocalDateTime.now());
            repository.save(updateClient);
        }else {
            throw  new ClientException("Client not found with id :"+id);
        }
    }

    @Override
    public Client login(LoginRequest client) {
        return null;
    }

    @Override
    public Client findClientByEmail(String email) {
        Client clientEmail = repository.findClientByEmail(email);
         if(clientEmail == null){
             throw  new ClientException("Client not found with email:" + email);
         }else {
             return repository.findClientByEmail(email);
         }
    }

    @Override
    public Client findClientById(Long id) {
        Optional<Client> existingClient = repository.findById(id);
        if(existingClient.isPresent()){
            Client clientId = existingClient.get();
             return  clientId;
        }else {
            throw  new ClientException("Client not found with id :"+id);
        }
    }
}

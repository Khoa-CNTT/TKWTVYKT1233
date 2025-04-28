package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Client;
import com.kltn.medicalwebsite.request.ClientRequest;
import com.kltn.medicalwebsite.request.LoginRequest;

import java.util.List;

public interface ClientService {

    List<Client> findALl();

    Client register(ClientRequest client);

    void updateClient(ClientRequest client , Long id);

    Client login(LoginRequest client);

    Client findClientByEmail(String email);
    Client findClientById(Long id);


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.service;

import com.insurancemanagement.exception.ResourceNotFound;
import com.insurancemanagement.model.Clients;
import com.insurancemanagement.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public Clients createClient(Clients client) {
        return clientRepository.save(client);
    }

    @Override
    public Clients updateClient(Clients client) {
        Optional<Clients> clientDb = this.clientRepository.findById(client.getId());
        
        if(clientDb.isPresent()){
            Clients clientUpdate = clientDb.get();
            clientUpdate.setId(client.getId());
            clientUpdate.setName(client.getName());
            clientUpdate.setDob(client.getDob());
            clientUpdate.setAddress(client.getAddress());
            clientUpdate.setContact(client.getContact());
            clientUpdate.setCreatedAt(client.getCreatedAt());
            clientRepository.save(clientUpdate);
            return clientUpdate;
        }
        else{
            throw new ResourceNotFound("No CLient found with id " + client.getId());
        }
        
    }

    @Override
    public List<Clients> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Clients getClientById(long clientId) {
        Optional<Clients> clientDb = this.clientRepository.findById(clientId);
        
        if(clientDb.isPresent()){
            return clientDb.get();
        }else{
            throw new ResourceNotFound("No CLient found with id " + clientId);
        }
    }

    @Override
    public void deleteClient(long clientId) {
        Optional<Clients> clientDb = this.clientRepository.findById(clientId);
        
        if(clientDb.isPresent()){
            this.clientRepository.delete(clientDb.get());
        }else{
            throw new ResourceNotFound("No CLient found with id " + clientId);
        }
    }
    
}

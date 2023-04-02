/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.controller;

import com.insurancemanagement.model.Clients;
import com.insurancemanagement.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saksh
 */
@RestController
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/api/clients")
    public ResponseEntity<List<Clients>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }
    
    
    @GetMapping("/api/clients/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable long id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @PostMapping("/api/clients")
    public ResponseEntity<Clients> createClient(@RequestBody Clients client) {
        return ResponseEntity.ok().body(this.clientService.createClient(client));
    }

    @PutMapping("/api/clients/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable long id, @RequestBody Clients client) {
        client.setId(id);
        return ResponseEntity.ok().body(this.clientService.updateClient(client));
    }

    @DeleteMapping("/api/clients/{id}")
    public HttpStatus deleteClient(@PathVariable long id) {
        this.clientService.deleteClient(id);
        return HttpStatus.OK;
    }
}

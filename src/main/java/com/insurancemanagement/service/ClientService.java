/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.insurancemanagement.service;
import com.insurancemanagement.model.Clients;
import java.util.List;

/**
 *
 * @author saksh
 */
public interface ClientService {
    Clients createClient(Clients client);
    Clients updateClient(Clients client);
    List<Clients> getAllClients();
    Clients getClientById(long clientId);
    void deleteClient(long clientId);
}

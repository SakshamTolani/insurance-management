/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.insurancemanagement.repository;

import com.insurancemanagement.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author saksh
 */
public interface ClientRepository extends JpaRepository<Clients, Long>{
    
}

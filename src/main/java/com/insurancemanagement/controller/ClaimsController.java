package com.insurancemanagement.controller;


import com.insurancemanagement.model.Claims;
import com.insurancemanagement.service.ClaimsService;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saksh
 */

@RestController
public class ClaimsController {

    @Autowired
    private ClaimsService claimService;

    @GetMapping("/api/claims")
    public ResponseEntity<List<Claims>> getAllClaims() {
        return ResponseEntity.ok().body(claimService.getAllClaims());
    }
    
    
    @GetMapping("/api/claims/{id}")
    public ResponseEntity<Claims> getClaimById(@PathVariable long id) {
        return ResponseEntity.ok().body(claimService.getClaimById(id));
    }

    @PostMapping("/api/claims")
    public ResponseEntity<Claims> createClaim(@RequestBody Claims claim) {
        return ResponseEntity.ok().body(this.claimService.createClaim(claim));
    }

    @PutMapping("/api/claims/{id}")
    public ResponseEntity<Claims> updateClaim(@PathVariable long id, @RequestBody Claims claim) {
        claim.setClaimNumber(id);
        return ResponseEntity.ok().body(this.claimService.updateClaim(claim));
    }

    @DeleteMapping("/api/claims/{id}")
    public HttpStatus deleteClaim(@PathVariable long id) {
        this.claimService.deleteClaim(id);
        return HttpStatus.OK;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.controller;

import com.insurancemanagement.model.InsurancePolicy;
import com.insurancemanagement.service.InsurancePolicyService;
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
public class InsurancePolicyController {
    
    @Autowired
    private InsurancePolicyService insurancePolicyService;
    
    @GetMapping("/api/policies")
    public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicys() {
        return ResponseEntity.ok().body(insurancePolicyService.getAllInsurancePolicys());
    }
    
    
    @GetMapping("/api/policies/{id}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable long id) {
        return ResponseEntity.ok().body(insurancePolicyService.getInsurancePolicyById(id));
    }

    @PostMapping("/api/policies")
    public ResponseEntity<InsurancePolicy> createInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        return ResponseEntity.ok().body(this.insurancePolicyService.createInsurancePolicy(insurancePolicy));
    }

    @PutMapping("/api/policies/{id}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable long id, @RequestBody InsurancePolicy insurancePolicy) {
        insurancePolicy.setPolicyNumber(id);
        return ResponseEntity.ok().body(this.insurancePolicyService.updateInsurancePolicy(insurancePolicy));
    }

    @DeleteMapping("/api/policies/{id}")
    public HttpStatus deleteInsurancePolicy(@PathVariable long id) {
        this.insurancePolicyService.deleteInsurancePolicy(id);
        return HttpStatus.OK;
    }
}

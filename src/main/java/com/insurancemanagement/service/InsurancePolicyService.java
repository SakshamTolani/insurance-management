/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.insurancemanagement.service;

import com.insurancemanagement.model.InsurancePolicy;
import java.util.List;

/**
 *
 * @author saksh
 */
public interface InsurancePolicyService {
    
    InsurancePolicy createInsurancePolicy(InsurancePolicy insurance);
    InsurancePolicy updateInsurancePolicy(InsurancePolicy insurance);
    List<InsurancePolicy> getAllInsurancePolicys();
    InsurancePolicy getInsurancePolicyById(long insuranceId);
    void deleteInsurancePolicy(long insuranceId);
}

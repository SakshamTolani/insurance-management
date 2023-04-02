/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.service;

import com.insurancemanagement.exception.ResourceNotFound;
import com.insurancemanagement.model.Clients;
import com.insurancemanagement.model.InsurancePolicy;
import com.insurancemanagement.repository.ClientRepository;
import com.insurancemanagement.repository.InsurancePolicyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author saksh
 */
@Service
@Transactional
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurance) {
        Optional<Clients> clientDb = this.clientRepository.findById(insurance.getClientId());
        if (clientDb.isPresent()) {

            return insurancePolicyRepository.save(insurance);
        } else {
            throw new ResourceNotFound("No Client found with id " + insurance.getClientId());
        }
    }

    @Override
    public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurance) {
        Optional<InsurancePolicy> insurancePolicyDb = this.insurancePolicyRepository.findById(insurance.getPolicyNumber());

        if (insurancePolicyDb.isPresent()) {
            InsurancePolicy insuranceUpdate = insurancePolicyDb.get();
            insuranceUpdate.setPolicyNumber(insurance.getPolicyNumber());
            insuranceUpdate.setPolicyType(insurance.getPolicyType());
            insuranceUpdate.setCoverageAmount(insurance.getCoverageAmount());
            insuranceUpdate.setPremium(insurance.getPremium());
            insuranceUpdate.setStartDate(insurance.getStartDate());
            insuranceUpdate.setEndDate(insurance.getEndDate());
            insuranceUpdate.setClientId(insurance.getClientId());
            insurancePolicyRepository.save(insuranceUpdate);
            return insuranceUpdate;
        } else {
            throw new ResourceNotFound("No Insurance Policy found with Policy Number " + insurance.getPolicyNumber());
        }
    }

    @Override
    public List<InsurancePolicy> getAllInsurancePolicys() {
        return this.insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy getInsurancePolicyById(long insuranceId) {
        Optional<InsurancePolicy> insuranceDb = this.insurancePolicyRepository.findById(insuranceId);
        if (insuranceDb.isPresent()) {
            return insuranceDb.get();
        } else {
            throw new ResourceNotFound("No Insurance Policy found with Policy Number " + insuranceId);
        }
    }

    @Override
    public void deleteInsurancePolicy(long insuranceId) {
        Optional<InsurancePolicy> insuranceDb = this.insurancePolicyRepository.findById(insuranceId);

        if (insuranceDb.isPresent()) {
            this.insurancePolicyRepository.delete(insuranceDb.get());
        } else {
            throw new ResourceNotFound("No Insurance Policy found with Policy Number " + insuranceId);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.service;

import com.insurancemanagement.exception.ResourceNotFound;
import com.insurancemanagement.model.Claims;
import com.insurancemanagement.model.InsurancePolicy;
import com.insurancemanagement.repository.ClaimRepository;
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
public class ClaimsServiceImpl implements ClaimsService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public Claims createClaim(Claims claim) {
        Optional<InsurancePolicy> insuranceDb = this.insurancePolicyRepository.findById(claim.getPolicyId());
        if (insuranceDb.isPresent()) {
            return claimRepository.save(claim);
        } else {
            throw new ResourceNotFound("No Insurance Policy found with id " + claim.getPolicyId());
        }
    }

    @Override
    public Claims updateClaim(Claims claim) {
        Optional<Claims> claimDb = this.claimRepository.findById(claim.getClaimNumber());

        if (claimDb.isPresent()) {
            Claims claimUpdate = claimDb.get();
            claimUpdate.setClaimNumber(claim.getClaimNumber());
            claimUpdate.setDescription(claim.getDescription());
            claimUpdate.setClaimDate(claim.getClaimDate());
            claimUpdate.setClaimStatus(claim.getClaimStatus());
            claimUpdate.setPolicyId(claim.getPolicyId());
            claimRepository.save(claimUpdate);
            return claimUpdate;
        } else {
            throw new ResourceNotFound("No Claim found with id " + claim.getClaimNumber());
        }

    }

    @Override
    public List<Claims> getAllClaims() {
        System.out.println(this.claimRepository);
        return this.claimRepository.findAll();
    }

    @Override
    public Claims getClaimById(long claimId) {
        Optional<Claims> claimDb = this.claimRepository.findById(claimId);

        if (claimDb.isPresent()) {
            return claimDb.get();
        } else {
            throw new ResourceNotFound("No Claim found with id " + claimId);
        }
    }

    @Override
    public void deleteClaim(long claimId) {
        Optional<Claims> claimDb = this.claimRepository.findById(claimId);

        if (claimDb.isPresent()) {
            this.claimRepository.delete(claimDb.get());
        } else {
            throw new ResourceNotFound("No Claim found with id " + claimId);
        }
    }

}

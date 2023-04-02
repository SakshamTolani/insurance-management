/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.insurancemanagement.service;

import com.insurancemanagement.model.Claims;
import java.util.List;

/**
 *
 * @author saksh
 */
public interface ClaimsService {
    Claims createClaim(Claims claim);
    Claims updateClaim(Claims claim);
    List<Claims> getAllClaims();
    Claims getClaimById(long claimId);
    void deleteClaim(long claimId);
}

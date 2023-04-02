/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.model;
import static jakarta.persistence.CascadeType.ALL;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
/**
 *
 * @author saksh
 */

@Entity
@Table(name="claims")
public class Claims {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="claimNumber")
    private long claimNumber;
    
    @Column(name="description")
    private String description;
    
    @Column(name="claimDate")
    private Date claimDate;
    
    @Column(name="claimStatus")
    private String claimStatus;
    
    @JoinColumn(name = "InsurancePolicy", referencedColumnName = "policyNumber")
    private long policyId;

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public long getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(long claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
    
    
    
}

package com.pragma.statuspipeline.domain.model;

import com.pragma.statuspipeline.domain.model.LoanRequestStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoanRequest {
    @Id
    private String id;
    private String clientId;
    private LoanRequestStatus status;
    // Getters and setters
}
package com.pragma.statuspipeline.infrastructure.adapter;

import com.pragma.statuspipeline.domain.model.LoanRequest;

public interface LoanRequestRepository {
    LoanRequest findById(String id);
    LoanRequest save(LoanRequest loanRequest);
}
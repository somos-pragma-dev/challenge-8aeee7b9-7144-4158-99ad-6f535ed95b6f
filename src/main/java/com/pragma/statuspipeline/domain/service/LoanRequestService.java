package com.pragma.statuspipeline.domain.service;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import com.pragma.statuspipeline.domain.model.LoanRequestStatus;

public interface LoanRequestService {
    LoanRequest transitionToNextStatus(LoanRequest loanRequest);
}
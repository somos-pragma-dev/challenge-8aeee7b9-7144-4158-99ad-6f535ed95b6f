package com.pragma.statuspipeline.infrastructure.adapter;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class LoanRequestRepositoryImpl implements LoanRequestRepository {
    private final JpaRepository<LoanRequest, String> loanRequestRepository;

    public LoanRequestRepositoryImpl(JpaRepository<LoanRequest, String> loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public LoanRequest findById(String id) {
        return loanRequestRepository.findById(id).orElse(null);
    }

    @Override
    public LoanRequest save(LoanRequest loanRequest) {
        return loanRequestRepository.save(loanRequest);
    }
}
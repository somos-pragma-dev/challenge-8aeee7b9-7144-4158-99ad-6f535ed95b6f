package com.pragma.statuspipeline.domain.service;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import com.pragma.statuspipeline.domain.model.LoanRequestStatus;
import com.pragma.statuspipeline.infrastructure.adapter.LoanRequestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoanRequestServiceTest {

    @Test
    public void testTransitionToNextStatus() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.RECEIVED);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.UNDER_REVIEW, updatedRequest.getStatus());
    }

    @Test
    public void testTransitionToApproved() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.UNDER_REVIEW);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.APPROVED, updatedRequest.getStatus());
    }

    @Test
    public void testTransitionToRejected() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.UNDER_REVIEW);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.REJECTED, updatedRequest.getStatus());
    }
}
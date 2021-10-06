package com.coder.financeApp.service;

import com.coder.financeApp.exception.ResourceNotFoundException;
import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.repository.CashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashFlowService {
    @Autowired
    CashFlowRepository repository;

    public CashFlow findById(Long fluxId) throws ResourceNotFoundException {
        return repository.findById(fluxId)
                .orElseThrow(() -> new ResourceNotFoundException("Flux not found: " + fluxId));
    }

    public CashFlow insert(CashFlow CashFlow){
        return repository.save(CashFlow);
    }

    public List<CashFlow> getAllCashFlow(){
        return repository.findAll();
    }
}

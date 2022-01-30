package com.coder.financeApp.service;

import com.coder.financeApp.dto.CashFlowRequestDto;
import com.coder.financeApp.exception.ResourceNotFoundException;
import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.model.User;
import com.coder.financeApp.repository.CashFlowRepository;
import com.coder.financeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class CashFlowService {
    @Autowired
    CashFlowRepository cashFlowRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    public CashFlow findById(Long fluxId) throws ResourceNotFoundException {
        return cashFlowRepository.findById(fluxId)
                .orElseThrow(() -> new ResourceNotFoundException("Flux not found: " + fluxId));
    }

    public CashFlow insert(CashFlowRequestDto cashFlowRequestDto) throws ResourceNotFoundException {

        CashFlow cashFlow = cashFlowRequestDto.getCashFlow().convertToCashFlow();
        User user = userService.findById(cashFlowRequestDto.getId_user());

        cashFlow.setUser(user);

        if (cashFlow.getTimestamp() == null){
            cashFlow.setTimestamp(Date.from(Instant.now()));
        }

        return cashFlowRepository.save(cashFlow);
    }

    public List<CashFlow> getAllCashFlow(){
        return cashFlowRepository.findAll();
    }
}

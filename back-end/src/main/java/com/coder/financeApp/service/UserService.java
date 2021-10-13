package com.coder.financeApp.service;

import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.repository.CashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    CashFlowRepository cashFlowRepository;


}

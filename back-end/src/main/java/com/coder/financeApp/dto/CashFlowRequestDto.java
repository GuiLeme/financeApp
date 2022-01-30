package com.coder.financeApp.dto;


import java.io.Serializable;

public class CashFlowRequestDto implements Serializable {

    private Long id_user;
    private CashFlowDto cashFlow;

    public CashFlowRequestDto(Long id_user, CashFlowDto cashFlow) {
        this.id_user = id_user;
        this.cashFlow = cashFlow;
    }

    public Long getId_user() {
        return id_user;
    }

    public CashFlowDto getCashFlow() {
        return cashFlow;
    }
}

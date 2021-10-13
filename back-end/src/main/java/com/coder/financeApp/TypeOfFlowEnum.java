package com.coder.financeApp;

public enum TypeOfFlowEnum {
    MARKET("Mercado"),
    SALARY("Salário"),
    GAS("Posto de gasolina"),
    ELECTRICITY("Conta de eletricidade"),
    WATER("Conta de água"),
    INTERNET("Conta de internet"),
    PHARMACY("Farmácia"),
    AID("Ajuda"),
    EXTRA("Dinheiro extra");

    public String typeOfFlow;

    TypeOfFlowEnum(String typeOfFlow) {
        this.typeOfFlow = typeOfFlow;
    }

    public String getTypeOfFlow(){
        return typeOfFlow;
    }
}

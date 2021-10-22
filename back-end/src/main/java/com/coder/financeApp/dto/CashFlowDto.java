package com.coder.financeApp.dto;

import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class CashFlowDto implements Serializable {
    private Long id;
    private User user;
    private String name;
    private Double price;
    private String type;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT")
    private Date timestamp;

    public CashFlowDto(Long id, User user, String name, Double price, String type, String description, Date timestamp) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
    }

    public CashFlow convertToCashFlow(){
        return new CashFlow(this.id, this.name, this.price,
                this.type, this.description, this.timestamp);
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

package com.coder.financeApp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cash_flow")
public class CashFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "_user_id")
    private User user;

    @Column(name = "_name")
    private String name;

    @Column(name = "_price")
    private Double price;

    @Column(name = "_type")
    private String type;

    @Column(name = "_description")
    private String description;

    @Column(name = "_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT")
    private Date timestamp;

    public CashFlow(){
    }

    public CashFlow(Long id, String name, Double price,
                    String type, String description, Date timestamp) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashFlow CashFlow = (CashFlow) o;
        return Objects.equals(id, CashFlow.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CashFlow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", timeStamp=" + timestamp +
                '}';
    }
}

package com.tradereport.domain;

import com.tradereport.domain.enumeration.Currency;
import com.tradereport.domain.enumeration.Entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by kateryna.sosonna on 7/7/2017.
 */
public class Trade implements Serializable {
    private static final long serialVersionUID = 1L;

    private Entity entity;
    private String buySell;
    private Double agreedFx;
    private Currency currency;
    private LocalDate InstructionDate;
    private LocalDate settlementDate;
    private Integer Units;
    private Double pricePerUnit;

    public Trade(Entity entity, String buySell, Double agreedFx, Currency currency, LocalDate instructionDate, LocalDate settlementDate, Integer units, Double pricePerUnit) {
        this.entity = entity;
        this.buySell = buySell;
        this.agreedFx = agreedFx;
        this.currency = currency;
        InstructionDate = instructionDate;
        this.settlementDate = settlementDate;
        Units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public Double getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(Double agreedFx) {
        this.agreedFx = agreedFx;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getInstructionDate() {
        return InstructionDate;
    }

    public void setInstructionDate(LocalDate instructionDate) {
        InstructionDate = instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Integer getUnits() {
        return Units;
    }

    public void setUnits(Integer units) {
        Units = units;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}

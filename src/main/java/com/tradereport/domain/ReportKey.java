package com.tradereport.domain;

import com.tradereport.domain.enumeration.Entity;

import java.time.LocalDate;

/**
 * Created by kateryna.sosonna on 7/9/2017.
 */
public class ReportKey {

    private String buySell;
    private LocalDate settlementDate;
    private Entity entity;

    public ReportKey() {
    }

    public ReportKey(String buySell, LocalDate settlementDate, Entity entity) {
        this.buySell = buySell;
        this.settlementDate = settlementDate;
        this.entity = entity;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}

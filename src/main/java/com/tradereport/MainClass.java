package com.tradereport;

import com.tradereport.domain.Trade;
import com.tradereport.domain.enumeration.Currency;
import com.tradereport.domain.enumeration.Entity;
import com.tradereport.service.TradeReportCalcService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kateryna.sosonna on 7/7/2017.
 */
public class MainClass {

    public static void main(String[] args) {
        List<Trade> listTrades = Arrays.asList(
                new Trade(Entity.FOO, "B", 0.5, Currency.SGP, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2), 200, 100.25),
                new Trade(Entity.FOO, "B", 0.5, Currency.SGP, LocalDate.of(2017, 7, 7), LocalDate.of(2017, 7, 7), 200, 100.25),// FRI
                new Trade(Entity.FOO, "S", 0.5, Currency.SGP, LocalDate.of(2017, 7, 7), LocalDate.of(2017, 7, 7), 200, 100.25),// FRI
                new Trade(Entity.BAR, "S", 0.22, Currency.AED, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 7), 450, 150.05),
                new Trade(Entity.BAR, "S", 0.22, Currency.USD, LocalDate.of(2017, 7, 11), LocalDate.of(2017, 7, 11), 600, 120.05),
                new Trade(Entity.BAR, "S", 0.22, Currency.USD, LocalDate.MAX, LocalDate.of(2017, 7, 11), 50, 120.05)
             //   new Trade(Entity.FOO, "B", 0.5, Currency.SGP, LocalDate.MAX, LocalDate.of(2017, 7, 7), 200, 100.25)// FRI
        );

        TradeReportCalcService tradeService = new TradeReportCalcService();
        tradeService.reportCalculation(listTrades);

    }
}

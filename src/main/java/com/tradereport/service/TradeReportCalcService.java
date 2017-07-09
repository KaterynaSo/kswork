package com.tradereport.service;

import com.tradereport.domain.Trade;
import com.tradereport.service.util.TradeUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by kateryna.sosonna on 7/7/2017.
 */
public class TradeReportCalcService {

    public void reportCalculation(List<Trade> listTrades) {

        //change Trade date to week day if not
        tradeDateConversion(listTrades);
        //calculate report
        Map<Object, Double> report = calcTradeIncomeOutcome(listTrades);

        System.out.println(report);
    }

    public void tradeDateConversion(List<Trade> listTrades) {
        for (Trade trade : listTrades) {
            LocalDate lc = trade.getInstructionDate();
            try {
                trade.setSettlementDate(TradeUtil.convertToWeekDay(lc, trade.getCurrency()));
            } catch (Exception e) {
                //in real App will use logging (slf4j, for example)
                System.out.println("Exception while date conversion for trade with date : " + lc
                        + ", Exception:" + e.toString());
            }
        }

    }

    public Map<Object, Double> calcTradeIncomeOutcome(List<Trade> tradeList) {

        Function<Trade, List<Object>> compositeKey = tradeRecord ->
                Arrays.<Object>asList(tradeRecord.getBuySell(), tradeRecord.getSettlementDate(), tradeRecord.getEntity());

        Map<Object, Double> summaryMap = tradeList.parallelStream().
                collect(groupingBy(compositeKey,
                        Collectors.summingDouble(TradeUtil::convertToUsd)));

        //sort entities
        Map<Object, Double> sorted = summaryMap.entrySet()
                .stream().sorted(Map.Entry.<Object, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        return sorted;

    }


}

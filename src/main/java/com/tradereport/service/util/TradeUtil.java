package com.tradereport.service.util;

import com.tradereport.domain.Trade;
import com.tradereport.domain.enumeration.Currency;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by kateryna.sosonna on 7/7/2017.
 */
public class TradeUtil {

    public static double convertToUsd(Trade trade) {
        return trade.getPricePerUnit() * trade.getUnits() * trade.getAgreedFx();
    }

    public static LocalDate convertToWeekDay(LocalDate localDate, Currency currency) {
        return DateStrategyFactory.getStrategy(localDate, currency).getDate();
    }

    interface DateStrategy {
        LocalDate getDate();
    }

    private static class DateStrategyFactory {
        static DateStrategy getStrategy(LocalDate localDate, Currency currency) {
            if (currency.equals(Currency.SGP) || currency.equals(Currency.AED)) {
                return getLocalDate(localDate, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
            } else {
                return getLocalDate(localDate, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
            }

        }

        private static DateStrategy getLocalDate(LocalDate localDate, DayOfWeek first, DayOfWeek second) {
            if (localDate.getDayOfWeek() == first) {
                return () -> localDate.plusDays(2);
            } else if (localDate.getDayOfWeek() == second) {
                return () -> localDate.plusDays(1);
            } else {
                return () -> localDate;
            }
        }
    }
}

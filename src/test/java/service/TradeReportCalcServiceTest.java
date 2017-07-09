package service;

import com.tradereport.domain.Trade;
import com.tradereport.domain.enumeration.Currency;
import com.tradereport.domain.enumeration.Entity;
import com.tradereport.service.TradeReportCalcService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by kateryna.sosonna on 7/9/2017.
 */
public class TradeReportCalcServiceTest {
    private TradeReportCalcService tradeReportCalcService;

    @Before
    public void setup() {
        tradeReportCalcService = new TradeReportCalcService();
    }

    @Test
    public void reportCalculationTest() {

        //test that outcome sum is properly calculated USD amount of a trade = Price per unit * Units * Agreed Fx
        List<Trade> listTrades = new ArrayList<>();
        listTrades.add(new Trade(Entity.FOO, "B", 0.5, Currency.SGP, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2), 200, 100.25));

        Double outcome = listTrades.get(0).getPricePerUnit() * listTrades.get(0).getUnits() * listTrades.get(0).getAgreedFx();
        Map<Object, Double> report = tradeReportCalcService.calcTradeIncomeOutcome(listTrades);
        List<Object> key = Arrays.asList(listTrades.get(0).getBuySell(), listTrades.get(0).getSettlementDate(), listTrades.get(0).getEntity());
        System.out.println();

        assertEquals(outcome, report.get(key));

    }

    @Test
    public void tradeDateConversionSGPTest() {
        List<Trade> listTrades = Arrays.asList(
                new Trade(Entity.FOO, "B", 0.5, Currency.SGP, LocalDate.of(2017, 7, 7) //FRI - not working day for SGP
                        , LocalDate.of(2016, 1, 2), 200, 100.25)
        );
        LocalDate newLc = LocalDate.of(2017, 7, 9);//MON
        tradeReportCalcService.tradeDateConversion(listTrades);
        assertEquals(newLc, listTrades.get(0).getSettlementDate());
    }

    @Test
    public void tradeDateConversionUSDTest() {
        List<Trade> listTrades = Arrays.asList(
                new Trade(Entity.FOO, "B", 0.5, Currency.USD, LocalDate.of(2017, 7, 7) //FRI -  working day for SGP
                        , LocalDate.of(2016, 1, 2), 200, 100.25)
        );
        LocalDate newLc = listTrades.get(0).getInstructionDate();
        tradeReportCalcService.tradeDateConversion(listTrades);
        assertEquals(newLc, listTrades.get(0).getSettlementDate());
    }
}

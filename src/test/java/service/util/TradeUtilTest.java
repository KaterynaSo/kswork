package service.util;

import com.tradereport.domain.enumeration.Currency;
import com.tradereport.service.util.TradeUtil;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by kateryna.sosonna on 7/9/2017.
 */
public class TradeUtilTest {
    @Test
    public void convertToWeekDayTest() {
       // TradeUtil tradeUtil = new TradeUtil();

        //test weekend day for SGP
        LocalDate lc = LocalDate.of(2017, 7, 7);//Fri
        Currency cur = Currency.SGP;
        LocalDate newLc = TradeUtil.convertToWeekDay(lc, cur);

        assertEquals(lc.plusDays(2), newLc);

        //test working day for AED
        lc = LocalDate.of(2017, 7, 6);//THU
        cur = Currency.AED;
        newLc = TradeUtil.convertToWeekDay(lc, cur);

        assertEquals(lc, newLc);

        //test weekend day for USD
        lc = LocalDate.of(2017, 7, 8);//SAT
        cur = Currency.USD;
        newLc = TradeUtil.convertToWeekDay(lc, cur);

        assertEquals(lc.plusDays(2), newLc);

        //test working day for USD
        lc = LocalDate.of(2017, 7, 7);//FRI
        cur = Currency.USD;
        newLc = TradeUtil.convertToWeekDay(lc, cur);

        assertEquals(lc, newLc);

    }
}

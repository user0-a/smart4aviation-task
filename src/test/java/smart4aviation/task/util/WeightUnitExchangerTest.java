package smart4aviation.task.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static smart4aviation.task.util.WeightUnitExchanger.kgToLb;
import static smart4aviation.task.util.WeightUnitExchanger.lbToKg;


class WeightUnitExchangerTest {

    @Test
    void lbToKgTest() {
        int lbWeight = 100;
        assertEquals(45,lbToKg(lbWeight));
    }

    @Test
    void kgToLbTest() {
        int kgWeight = 100;
        assertEquals(220,kgToLb(kgWeight));
    }
}
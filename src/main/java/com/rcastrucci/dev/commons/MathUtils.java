package com.rcastrucci.dev.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility Class related to math operations
 */
public class MathUtils {

    /**
     * Calculate BigDecimal percentage
     * @param value value to be calculated
     * @param percentage percentage to be calculated
     * @return result of calculation
     */
    public static BigDecimal percentage(BigDecimal value, BigDecimal percentage){
        return value.multiply(percentage).divide(new BigDecimal(100), RoundingMode.UNNECESSARY);
    }

}

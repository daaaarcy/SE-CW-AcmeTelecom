package com.acmetelecom.calc;

import com.acmetelecom.Call;
import com.acmetelecom.database.ITariff;

import java.math.BigDecimal;

/**
 * Interface for cost calculator.
 * <p/>
 * User: darcy
 * Date: 03/12/2012
 * Time: 12:12
 */
public interface ICalculator
{
    public BigDecimal calculateCost(Call call, ITariff tariff);
}

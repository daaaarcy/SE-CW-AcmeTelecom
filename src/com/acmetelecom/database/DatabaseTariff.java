package com.acmetelecom.database;

import com.acmetelecom.customer.Tariff;

import java.math.BigDecimal;

public class DatabaseTariff implements ITariff
{
    private Tariff tariff;

    public DatabaseTariff(Tariff tariff)
    {
        this.tariff = tariff;
    }

    @Override
    public BigDecimal offPeakRate()
    {
        return tariff.offPeakRate();
    }

    @Override
    public BigDecimal peakRate()
    {
        return tariff.peakRate();
    }

    @Override
    public String name()
    {
        return tariff.name();
    }

}

package com.daehosting;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TemperatureConversionsTest {

    private TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();

    @Test
    public void getTemperatureConversionsSoap() {

        BigDecimal result = service.windChillInFahrenheit(BigDecimal.valueOf(34), BigDecimal.valueOf(20));
        assertEquals(BigDecimal.valueOf(4.334), result);
    }

    @Test
    public void getTemperatureConversionsSoap1() {

        BigDecimal result = service.windChillInCelsius(BigDecimal.valueOf(2), BigDecimal.valueOf(20));
        assertEquals(BigDecimal.valueOf(-14.17), result);
    }

    @Test
    public void getTemperatureConversionsSoap12() {

        BigDecimal result = service.celsiusToFahrenheit(BigDecimal.valueOf(0));
        assertEquals(BigDecimal.valueOf(32), result);
    }

    @Test
    public void getTemperatureConversionsSoap121() {

        BigDecimal result = service.fahrenheitToCelsius(BigDecimal.valueOf(84));
        assertEquals(BigDecimal.valueOf(28.88888885), result);
    }
}
package com.example.demo1;

public class Model {
    private static final double EURaMXN = 18.72;
    private static final double USDaMXN = 17.11;
    private static final double USDaEUR = 0.91;
    private static final double MXNaUSD = 0.060;
    private static final double MXNaEUR = 0.050;
    private static final double EURaUSD = 1.09;


    public double converse(String currencyOrigin, String currencyTarget, double quantity) {
        double exchangeRate = getExchangeRate(currencyOrigin, currencyTarget);
        return quantity * exchangeRate;
    }

    public double getExchangeRate(String currencyOrigin, String currencyTarget) {
        if ("USD".equals(currencyOrigin)) {
            if ("USD".equals(currencyTarget)) {
                return 1.0;
            } else if ("MXN".equals(currencyTarget)) {
                return USDaMXN;
            } else if ("EUR".equals(currencyTarget)) {
                return USDaEUR;
            } else {
                return 1.0;
            }
        } else if ("MXN".equals(currencyOrigin)) {
            if ("USD".equals(currencyTarget)) {
                return MXNaUSD;
            } else if ("MXN".equals(currencyTarget)) {
                return 1.0;
            } else if ("EUR".equals(currencyTarget)) {
                return MXNaEUR;
            } else {
                return 1.0;
            }
        } else if ("EUR".equals(currencyOrigin)) {
            if ("USD".equals(currencyTarget)) {
                return EURaUSD;
            } else if ("MXN".equals(currencyTarget)) {
                return EURaMXN;
            } else if ("EUR".equals(currencyTarget)) {
                return 1.0;
            } else {
                return 1.0;
            }
        } else {
            return 1.0;
        }
    }
}

package fr.kata;

public interface ExchangeRateProvider {
    Double getExchangeRateValue(Type type, Currency currency);
}

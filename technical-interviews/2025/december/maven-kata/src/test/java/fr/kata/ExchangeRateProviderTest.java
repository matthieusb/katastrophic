package fr.kata;

public class ExchangeRateProviderTest implements ExchangeRateProvider {

    @Override
    public Double getExchangeRateValue(Type type, Currency currency) {
        if (currency.equals(new Currency("Euro"))) {
            if (type.equals(new Type("Euro"))) {
                return 1.0;
            }

            if (type.equals(new Type("Dollar"))) {
                return 4.0;
            }
        }

        if (currency.equals(new Currency("Dollar"))) {
            return 1.0;
        }

        return 0.0;
    }
}

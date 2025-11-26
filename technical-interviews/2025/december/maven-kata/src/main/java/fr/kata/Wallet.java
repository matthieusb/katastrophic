package fr.kata;

import java.util.List;

public record Wallet(List<FinancialAsset> financialAssets) {
    public Wallet() {
        this(List.of());
    }

    public Double computeValue(Currency currency, ExchangeRateProvider provider) {
        return financialAssets.stream().map(financialAsset ->
                provider.getExchangeRateValue(financialAsset.type(), currency) * financialAsset.quantity().value())
                .reduce(Double::sum)
                .orElse(0.0);
    }
}

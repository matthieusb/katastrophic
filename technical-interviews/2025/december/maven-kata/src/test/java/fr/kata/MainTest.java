package fr.kata;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {

    public static final Currency EURO = new Currency("Euro");
    public static final Currency DOLLAR = new Currency();

    private final ExchangeRateProvider provider = new ExchangeRateProviderTest();

    @Test
    public void emptyWalletShouldComputeZeroValue() {
        Wallet wallet = new Wallet();

        assertThat(wallet.computeValue(DOLLAR, provider)).isEqualTo(0.0D);
    }

    @Test
    public void simpleWalletWithOneFinancialAssetShouldCompute() {
        FinancialAsset  financialAsset = new FinancialAsset(new Type("Dollar"), new Quantity(1));
        Wallet wallet = new Wallet(List.of(financialAsset));

        assertThat(wallet.computeValue(DOLLAR, provider)).isEqualTo(1.0D);
    }

    @Test
    public void simpleWalletWithSeveralFinancialAssetShouldCompute() {
        FinancialAsset  financialAsset = new FinancialAsset(new Type("Dollar"), new Quantity(1));
        Wallet wallet = new Wallet(List.of(financialAsset, financialAsset));

        assertThat(wallet.computeValue(DOLLAR, provider)).isEqualTo(2.0D);
    }

    @Test
    public void complexWalletWithSeveralDifferentFinancialAssetsShouldCompute() {
        FinancialAsset financialAssetDollar = new FinancialAsset(new Type("Dollar"), new Quantity(5));
        FinancialAsset financialAssetEuro = new FinancialAsset(new Type("Euro"), new Quantity(10));
        Wallet wallet = new Wallet(List.of(financialAssetDollar, financialAssetEuro));

        assertThat(wallet.computeValue(EURO, provider)).isEqualTo(30.0);
    }
}

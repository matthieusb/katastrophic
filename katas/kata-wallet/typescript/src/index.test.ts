import { describe, it, expect } from "vitest";


describe("Stock wallet features", () => {
    it("should compute wallet value for one simple stock with a simple type", () => {

        const stock = new Stock(5, StockType.PETROLEUM);

        const rateProvider = (from: StockType, to: Currency) => 12.0;

        const walletValue = compute_value(new Wallet(Currency.EUR, rateProvider, stock));

        expect(walletValue).toBe(60.0);
    });

    it("should compute wallet value for 2 simple stocks with different types", () => {
        const rateProvider = (from: StockType, to: Currency) => {
            if (from == StockType.GRASS) {
                return 1.6
            }

            if (from == StockType.PETROLEUM) {
                return 12.0
            }

            return 1.0;
        };

        const walletValue = compute_value(new Wallet(Currency.EUR, rateProvider,
            new Stock(5, StockType.PETROLEUM),
            new Stock(8, StockType.GRASS))
        );

        expect(walletValue).toBe(72.8);
    });
});

const compute_value = (wallet: Wallet) => {
    return wallet.stocks.reduce((acc, current) =>
        wallet.rateProvider(current.type, wallet.currency) * current.quantity + acc,
        0.0
    );
};

class Wallet {
    private readonly _stocks: Stock[];

    constructor(readonly currency: Currency, readonly rateProvider: (from: StockType, to: Currency) => number, ...stocks: Stock[]) {
        this._stocks = stocks;
    }

    get stocks(): Stock[] {
        return this._stocks;
    }
}

class Stock {
    constructor(readonly quantity: number, readonly type: StockType) {}
}

enum Currency {
    EUR
}

enum StockType {
    PETROLEUM,
    GRASS,
}
# kata typescript starter

## Specification

Given a Wallet containing Stocks, build a function that compute the value of wallet in a currency.

The Stocks have a quantity and a StockType. The StockType can be for example petroleum, Euros, bitcoins and Dollars.

To value the portfolio in a Currency you can use external api to provide rate exchanges (some are provided below).

### Object sample

```typescript
Value value = Wallet(Stock(5, PETROLEUM)).value(EUR, rateProvider)
```

With rateProvider an implementation of this interface :
```typescript
rateProvider.rate(from: StockType, to: Currency) -> double
```

### Functional sample

```typescript
Value value = compute_value(Wallet(Stock(5, PETROLEUM), EUR, rateProvider))
```

Where rateProvider is a function with this signature :

```typescript
rateProvider(from: StockType, to: Currency) -> double
```

and PETROLEUM is a StockType and EUR is a Currency.

## Pre-requisites

You need **node** and **npm** installed

## Installation

Simply run:

```bash
npm install
```

## Development

```bash
npm run compile

# Watch compile
npm run compile:watch
```

Test watch:
```bash
npm run test
```

Coverage:
```bash
npm run coverage
```

See *package.json* scripts for more info.

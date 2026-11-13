def changes(amount, coins):
    filtered_coins = [coin for coin in coins if coin <= amount] # Keep only coins that are not superior

    ways = [0] * (amount + 1)
    ways[0] = 1  # one way to make 0 (use nothing)

    for coin in filtered_coins:  # introduce one coin type at a time
        for a in range(coin, amount + 1):  # amounts that can use coin
            ways[a] += ways[a - coin]

    return ways[amount]

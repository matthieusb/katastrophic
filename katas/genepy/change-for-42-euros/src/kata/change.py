def changes_rec(amount, coins, acc, memo):
    if amount in memo:
        return memo[amount]
    else:
        memo_copy = memo
        sets_of_change = 0
        original_amount = amount

        while amount != 0:
            for coin in coins:
                if coin < amount:
                    amount -= coin
                    sets_of_change += 1

        memo_copy[original_amount] = sets_of_change

        return changes_rec(original_amount, coins[1:], acc + sets_of_change, memo_copy)


def changes(amount, coins):
    filtered_coins = [coin for coin in coins if coin <= amount]
    sorted_coins = sorted(filtered_coins, reverse=True)

    memo = {1: 1, 2: 3, 3: 5, 4: 9, 5: 13, 6: 20, 7: 27, 8: 37}

    return changes_rec(amount, sorted_coins, 0, memo)
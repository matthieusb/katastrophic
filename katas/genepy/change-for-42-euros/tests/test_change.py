from assertpy import assert_that
import pytest

from kata.change import changes

COINS = (1, 2, 5, 10, 20, 50, 100, 200, 500)

@pytest.mark.parametrize("amount,expected", [
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 3),
    (5, 4),
    (6, 5),
    (7, 6),
    (8, 7),
    (42, 271)
])
def test_changes(amount, expected):
    assert_that(changes(amount, COINS)).is_equal_to(expected)


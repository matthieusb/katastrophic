from assertpy import assert_that

from kata.change import changes

COINS = (1, 2, 5, 10, 20, 50, 100, 200, 500)

def test_one():
    assert_that(changes(1, COINS)).is_equal_to(1)

def test_two():
    assert_that(changes(2, COINS)).is_equal_to(3)

def test_nine():
    assert_that(changes(9, COINS)).is_equal_to(23)

# def test_fourty_two():
#     assert_that(changes(42, COINS)).is_equal_to(271)


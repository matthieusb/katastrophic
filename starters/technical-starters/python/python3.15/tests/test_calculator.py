from assertpy import assert_that

from kata.calculator import add, substract


def test_add():
    assert add(1, 2) == 3


def test_subtract():
    assert_that(substract(5, 3)).is_equal_to(2)

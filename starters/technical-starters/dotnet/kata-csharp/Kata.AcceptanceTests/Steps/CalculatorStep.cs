using NFluent;
using TechTalk.SpecFlow;

namespace Kata.AcceptanceTests.Steps;

[Binding]
public class CalculatorStep
{
    private int _firstNumber;
    private int _secondNumber;
    private int _sum;

    [Given(@"the first number is (.*)")]
    public void GivenTheFirstNumberIs(int firstNumber)
    {
        this._firstNumber = firstNumber;
    }

    [Given(@"the second number is (.*)")]
    public void GivenTheSecondNumberIs(int secondNumber)
    {
        this._secondNumber = secondNumber;
    }

    [When(@"the two numbers are added")]
    public void WhenTheTwoNumbersAreAdded()
    {
        this._sum = _firstNumber + _secondNumber;
    }

    [Then(@"the result should be (.*)")]
    public void ThenTheResultShouldBe(int expectedResult)
    {
        Check.That(_sum).IsEqualTo(expectedResult);
    }
}
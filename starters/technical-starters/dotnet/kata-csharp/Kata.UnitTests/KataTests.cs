using NFluent;

namespace Kata.UnitTests;

public class KataTests
{
    [Fact]
    public void Should_Compute()
    {
        Kata kata = new Kata();
        
        Check.That(kata.Compute()).Equals(42);
    }
}
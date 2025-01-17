module Tests

open Kata
open Xunit

[<Fact>]
let ``Dummy test`` () =
    Assert.True(true)

[<Fact>]
let ``Test addition`` () =
    Assert.Equal(4, Calculator.add 2 2)

using Microsoft.Extensions.DependencyInjection;
using SolidToken.SpecFlow.DependencyInjection;

namespace Kata.AcceptanceTests.Configuration;

public class ScenarioInitiliazer
{
    [ScenarioDependencies]
    public static IServiceCollection RegisterCoreAcceptanceTestServices()
    {
        var services = new ServiceCollection();

        return services;
    }
}
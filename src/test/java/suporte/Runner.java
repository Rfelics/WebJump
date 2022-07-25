package suporte;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Avaliacao.feature",
        glue = "steps",
        plugin = "pretty",
        tags = "@Cenario3"
)
public class Runner {
}

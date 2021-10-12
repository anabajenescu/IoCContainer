package test.java.container;

import main.java.container.ConfigurationParameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static main.java.container.ConfigurationParameters.*;

public class ConfigurationParametersTest {

    @Test
    public void shouldHaveSameElements() {
        List<ConfigurationParameters> actual = Arrays.stream(values()).collect(toList());
        Assert.assertEquals(
                actual,
                asList(
                        DATABASE_FILE,
                        INTERFACE_CLASS,
                        IMPLEMENTATION_CLASS,
                        COMPONENT_INSTANCE,
                        METHOD_NAME,
                        METHOD_PARAMETER
                )
        );
    }
}

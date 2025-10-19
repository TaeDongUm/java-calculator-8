package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import calculator.domain.Calculator;

public class CalculatorTest extends NsTest {

    Calculator calculator = new Calculator();

    @Test
    void Empty_String_ReturnsZero() {
        assertThat(calculator.calculate("0")).isEqualTo(0);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

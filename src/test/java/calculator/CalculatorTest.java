package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.domain.Calculator;

public class CalculatorTest extends NsTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("빈 문자열일 경우 0을 반환한다.")
    void Empty_String_ReturnsZero() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자(, :) : 합산 테스트 ")
    void Default_Separator_Calculate() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.domain.Calculator;

public class CalculatorTest extends NsTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("빈 문자열일 경우 0을 반환한다.")
    void Empty_String_ReturnsZero() {
        assertThat(calculator.calculate("0")).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자(, :) : 합산 테스트 ")
    void Default_Separator_Calculate() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자는 한글자로 인식한다.")
    void Custom_Delimiter_Is_One_Letter() {
        assertDoesNotThrow(() ->
                calculator.calculate("//;\\n1;2:3")
        );


    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

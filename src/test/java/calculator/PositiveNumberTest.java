package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.PositiveNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositiveNumberTest extends NsTest {

    @ParameterizedTest
    @DisplayName("선행 0이 포함된 숫자 문자열은 정상적으로 합산된다.")
    @CsvSource({
            "01,1",
            "010,10",
            "001,1"
    })
    void When_Number_Has_LeadingZero_Then_CalculatedCorrectly(String input, int expected) {
        PositiveNumber positiveNumber = new PositiveNumber(input);
        assertThat(positiveNumber.getValue()).isEqualTo(expected);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

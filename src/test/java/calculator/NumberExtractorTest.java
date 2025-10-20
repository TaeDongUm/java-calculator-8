package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberExtractorTest extends NsTest {

    NumberExtractor extractor = new NumberExtractor();

    @ParameterizedTest
    @DisplayName("음수, 소수, 문자가 포함된 경우 IllegalArgumentException 발생")
    @ValueSource(strings = {"1,-2,3", "1,2.5,3", "1,a,3"})
    void When_Input_Contains_Invalid_Tokens(String input) {
        assertThatThrownBy(() -> extractor.extractNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 토큰이 포함된 경우 예외 발생")
    void When_Extracted_Results_Contains_Invalid_Empty_Tokens() {
        String input = "1,,2";

        assertThatThrownBy(() -> extractor.extractNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

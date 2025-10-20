package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Delimiter;
import calculator.domain.NumberExtractor;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberExtractorTest extends NsTest {

    NumberExtractor extractor = new NumberExtractor();

    private static Stream<Arguments> provideListTokensForCalculation() {
        return Stream.of(
                Arguments.of(List.of("1", "-2", "3")),
                Arguments.of(List.of("1", "1.4", "5")),
                Arguments.of(List.of("1", "a", "3"))
        );
    }

    @ParameterizedTest
    @DisplayName("음수, 소수, 문자가 포함된 경우 IllegalArgumentException 발생")
    @MethodSource("provideListTokensForCalculation")
    void When_Input_Contains_Invalid_Tokens(List<String> input) {
        assertThatThrownBy(() -> extractor.extractNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 사이에 공백이 포함되면 예외가 발생한다.")
    @ValueSource(strings = {"1 ,2", " 3", "4 ", "5, 6", "7 :8", "9: 10"})
    void When_Tokens_Contains_Whitespace(String input) {
        Delimiter delimiter = Delimiter.ofDefault();
        List<String> tokens = delimiter.split(input);
        NumberExtractor extractor = new NumberExtractor();

        assertThatThrownBy(() ->
                extractor.extractNumber(tokens)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

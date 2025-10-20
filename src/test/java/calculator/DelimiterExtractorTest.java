package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterExtractorTest extends NsTest {

    DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    @Test
    @DisplayName("커스텀 구분자 길이가 2글자 이상일 경우 예외 발생")
    void If_Custom_Delimiter_Length_Over_One() {
        assertThatThrownBy (() ->
                delimiterExtractor.validateIfCustomDelimiterLengthOverOne("//++\\n1,2;3")
                        .isInstanceOf(IllegalArgumentException.class)

        );

    }

    @Test
    @DisplayName("커스텀 구분자가 개행 문자일 경우 예외 발생")
    void If_Custom_Delimiter_EqualTo_Newline_Character() {
        assertThatThrownBy (() ->
                delimiterExtractor.validateIfCustomDelimiterHasNewLine("//\n\\n1,2;3")
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    @DisplayName("커스텀 구분자가 공백일 경우 예외 발생")
    void If_Custom_Delimiter_Has_Whitespace_Character() {
        assertThatThrownBy (() ->
                delimiterExtractor.validateIfCustomDelimiterHasWhitespace("// \\n1,2;3")
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자가 들어오는 경우 예외 발생")
    void If_Custom_Delimiter_Has_Number_Character() {
        assertThatThrownBy (() ->
                delimiterExtractor.validateIfCustomDelimiterHasNumber("//3\\n1,2;3")
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}

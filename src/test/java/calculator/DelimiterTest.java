package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.domain.Delimiter;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DelimiterTest extends NsTest {

    Delimiter delimiter = Delimiter.ofDefault();

    @Test
    @DisplayName("커스텀 구분자는 한글자로 인식한다.")
    void Custom_Delimiter_Is_One_Letter() {
        assertDoesNotThrow(() ->
                delimiter.withCustom('e')
        );
    }

    @ParameterizedTest
    @ValueSource(chars = {'*', '.', '?', '+', '|', '^', '(', ')', '[', ']', '{', '}', '\\'})
    @DisplayName("정규식 메타문자 구분자 허용 테스트")
    void Custom_Delimiter_Contains_Regex_Meta_Char_Test(char regexMetaChar) {
        Delimiter delimiter = Delimiter.ofDefault().withCustom(regexMetaChar);

        String input = "1" + regexMetaChar + "2" + regexMetaChar + "3";
        List<String> result = delimiter.split(input);

        assertThat(result).contains("1", "2", "3");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}

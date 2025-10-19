package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.domain.Delimiter;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest extends NsTest {

    Delimiter delimiter = Delimiter.ofDefault();

    @Test
    @DisplayName("커스텀 구분자는 한글자로 인식한다.")
    void Custom_Delimiter_Is_One_Letter() {
        assertDoesNotThrow(() ->
                delimiter.withCustom('e')
        );


    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}

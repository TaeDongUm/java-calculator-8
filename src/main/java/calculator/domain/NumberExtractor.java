package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public List<PositiveNumber> extractNumber(List<String> tokenizedNumbers) {
        List<PositiveNumber> numbers = new ArrayList<>();

        for (String token : tokenizedNumbers) {
            validate(token);
            numbers.add(new PositiveNumber(token));
        }
        return numbers;
    }

    public void validate(String token) {
        if (token.contains(" ")) {
            throw new IllegalArgumentException("ERROR: 숫자 사이에 공백이 존재할 수 없습니다.");
        }
    }


}

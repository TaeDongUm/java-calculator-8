package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public List<Integer> extractNumber(List<String> tokenizedNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokenizedNumbers) {
            validate(token);
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    public void validate(String token) {
        validateIfTokenEmpty(token);
        validateIfTokensAreOtherThanNumber(token);
    }

    public void validateIfTokenEmpty(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException("ERROR: 구분자 사이에 빈 문자열은 존재할 수 없습니다.");
        }
    }

    public void validateIfTokensAreOtherThanNumber(String token) {
        if (!token.matches("^[0]*[1-9][0-9]*$")) {
            throw new IllegalArgumentException("ERROR: 양수만 가능합니다.");
        }
    }

}

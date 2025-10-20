package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public List<PositiveNumber> extractNumber(List<String> tokenizedNumbers) {
        List<PositiveNumber> numbers = new ArrayList<>();

        for (String token : tokenizedNumbers) {
            numbers.add(new PositiveNumber(token));
        }
        return numbers;
    }



}

package calculator.domain;

import java.util.List;

public class Calculator {

    private final NumberExtractor numberExtractor;
    private final DelimiterExtractor delimiterExtractor;

    public Calculator(NumberExtractor numberExtractor, DelimiterExtractor delimiterExtractor) {
        this.numberExtractor = numberExtractor;
        this.delimiterExtractor = delimiterExtractor;
    }

    public int calculate(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        Delimiter delimiter = Delimiter.ofDefault().withCustom(delimiterExtractor.extractDelimiter(inputString));
        List<String> tokenizedNumbers = delimiter.split(inputString);
        List<PositiveNumber> positiveNumbers = numberExtractor.extractNumber(tokenizedNumbers);
        int sum = 0;
        for (PositiveNumber token : positiveNumbers) {
            sum += token.getValue();
        }

        return sum;
    }
}

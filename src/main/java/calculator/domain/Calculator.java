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

        ExtractionResult result = delimiterExtractor.extract(inputString);

        Delimiter delimiter = Delimiter.ofDefault();
        Character customDelimiter = result.getCustomDelimiter();

        if (customDelimiter != null) {
            delimiter = delimiter.withCustom(customDelimiter);
        }

        List<String> tokenizedNumbers = delimiter.split(result.getNumbersString());
        List<PositiveNumber> positiveNumbers = numberExtractor.extractNumber(tokenizedNumbers);

        return positiveNumbers.stream()
                .mapToInt(PositiveNumber::getValue)
                .sum();

    }
}

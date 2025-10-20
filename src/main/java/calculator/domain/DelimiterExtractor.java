package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    // 커스텀 구분자 패턴: //(구분자)\n(숫자)
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\n(.*)$");
    public DelimiterExtractor() {}

    public ExtractionResult extract(String userInput) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(userInput);

        if (matcher.find()) {
            String delimiterString = matcher.group(1); // 1. 구분자
            String numbersString = matcher.group(2);   // 2. 숫자 문자열

            validateCustomDelimiter(delimiterString);
            return new ExtractionResult(delimiterString.charAt(0), numbersString);
        }
        // 커스텀 구분자가 없는 경우 (delimiter=null, numbersString=원본)
        return new ExtractionResult(null, userInput);
    }

    private void validateCustomDelimiter(String delimiter) {
        validateIfCustomDelimiterLengthOverOne(delimiter);
        validateIfCustomDelimiterHasWhitespace(delimiter);
        validateIfCustomDelimiterHasNumber(delimiter);
    }



    public void validateIfCustomDelimiterHasWhitespace(String delimiter) {
        char token = delimiter.charAt(0);
        if (Character.isWhitespace(token)) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자는 공백을 가질 수 없습니다.");
        }
    }

    public void validateIfCustomDelimiterLengthOverOne(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자 길이는 1글자여야 합니다.");
        }
    }

    public void validateIfCustomDelimiterHasNumber(String delimiter) {
        char token = delimiter.charAt(0);
        if (Character.isDigit(token)) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

}

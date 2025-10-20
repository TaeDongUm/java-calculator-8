package calculator.domain;

public class DelimiterExtractor {

    private char delimiter;
    public DelimiterExtractor() {}

    public char extractDelimiter(String userInput) {
        validate(userInput);
        return userInput.charAt(2);
    }

    public void validate(String userInput) {
        validateIfCustomDelimiterHasWhitespace(userInput);
        validateIfCustomDelimiterHasNewLine(userInput);
        validateIfCustomDelimiterLengthOverOne(userInput);
        validateIfCustomDelimiterHasNumber(userInput);
    }

    public void validateIfCustomDelimiterHasWhitespace(String userInput) {
        int startIndex = userInput.indexOf("//");
        int endIndex = userInput.lastIndexOf("\\n");
        if (endIndex - startIndex != 3) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자는 공백을 가질 수 없습니다.");
        }
    }

    public void validateIfCustomDelimiterHasNewLine(String userInput) {
        String customFormat = userInput.substring(0, 4);
        if (customFormat.contains("\n")) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자로 개행 문자가 올 수 없습니다.");
        }
    }

    public void validateIfCustomDelimiterLengthOverOne(String userInput) {
        int startIndex = userInput.indexOf("//");
        int endIndex = userInput.lastIndexOf("\\n");
        if (endIndex - startIndex >= 4) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자 길이가 2글자 이상이 올 수 없습니다.");
        }
    }

    public void validateIfCustomDelimiterHasNumber(String userInput) {
        int startIndex = userInput.indexOf("//");
        int endIndex = userInput.lastIndexOf("\\n");
        String customDelimiter = userInput.substring(startIndex, endIndex);
        if ( !customDelimiter.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("ERROR: 커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

}

package calculator.domain;

public class ExtractionResult {
    private final Character customDelimiter;
    private final String numbersString;

    public ExtractionResult(Character customDelimiter, String numbersString) {
        this.customDelimiter = customDelimiter;
        this.numbersString = numbersString;
    }

    public Character getCustomDelimiter() {
        return customDelimiter;
    }

    public String getNumbersString() {
        return numbersString;
    }
}

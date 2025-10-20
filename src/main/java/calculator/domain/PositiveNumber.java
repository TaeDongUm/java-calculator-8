package calculator.domain;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(String token) {
        validate(token);
        this.value = Integer.parseInt(token);
    }

    public void validate(String token) {
        validateIfTokenEmpty(token);
        validateIfTokensAreOtherThanNumber(token);
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR: Integer 범위를 초과했습니다.");
        }
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

    public int getValue() {
        return value;
    }
}

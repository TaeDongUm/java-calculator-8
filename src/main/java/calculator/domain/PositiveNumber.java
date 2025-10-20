package calculator.domain;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            if (token.matches("^-?\\d+$")) {
                throw new IllegalArgumentException("ERROR: Integer 범위를 초과했습니다.");
            }

            throw new IllegalArgumentException("ERROR: 숫자 형식이 잘못되었습니다.");
        }

        validateIfPositive(number); // 0 또는 음수인지 검사

        this.value = number;
    }

    public void validateIfPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("ERROR: 양수만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}

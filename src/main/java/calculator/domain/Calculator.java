package calculator.domain;

import java.util.List;

public class Calculator {
    public Calculator() {}

    public int calculate(String inputString) {
        if(inputString.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = Delimiter.ofDefault().withCustom('e'); // 커스텀 구분자 추출 기능 추후 추가 필요
        List<String> inputNumbers = delimiter.split(inputString);
        int sum = 0;
        for (String token : inputNumbers) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}

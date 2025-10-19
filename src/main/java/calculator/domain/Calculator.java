package calculator.domain;

import java.util.List;

public class Calculator {
    public Calculator() {}

    public int calculate(String inputString) {
        if(inputString.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = Delimiter.ofDefault();
        List<String> inputNumbers = delimiter.split(inputString);
        int sum = 0;
        for (String token : inputNumbers) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}

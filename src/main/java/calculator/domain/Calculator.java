package calculator.domain;

public class Calculator {
    public Calculator() {}

    public int calculate(String inputString) {
        if(inputString.isEmpty()) {
            return 0;
        }

        String[] tokens = inputString.split("[,:]");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}

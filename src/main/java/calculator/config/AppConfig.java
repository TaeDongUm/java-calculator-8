package calculator.config;

import calculator.controller.StringCalculatorController;
import calculator.domain.Calculator;
import calculator.view.InputView;

public class AppConfig {
    public static StringCalculatorController createController() {

        InputView inputView = new InputView();
        Calculator calculator = new Calculator();

        return new StringCalculatorController(inputView, calculator);

    }
}

package calculator.config;

import calculator.controller.StringCalculatorController;
import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public static StringCalculatorController createController() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();

        return new StringCalculatorController(inputView, outputView, calculator);

    }
}

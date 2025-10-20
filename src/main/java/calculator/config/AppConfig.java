package calculator.config;

import calculator.controller.StringCalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public static StringCalculatorController createController() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        return new StringCalculatorController(inputView, outputView, calculator, delimiterExtractor);

    }
}

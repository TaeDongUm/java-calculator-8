package calculator.config;

import calculator.controller.StringCalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.NumberExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public static StringCalculatorController createController() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberExtractor numberExtractor = new NumberExtractor();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Calculator calculator = new Calculator(numberExtractor, delimiterExtractor);

        return new StringCalculatorController(inputView, outputView, calculator);

    }
}

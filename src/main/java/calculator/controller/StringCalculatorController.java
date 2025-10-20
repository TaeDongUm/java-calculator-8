package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.text.DecimalFormat;

public class StringCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final DelimiterExtractor delimiterExtractor;

    public StringCalculatorController(InputView inputView, OutputView outputView, Calculator calculator,
                                      DelimiterExtractor delimiterExtractor) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        this.delimiterExtractor = delimiterExtractor;
    }

    public void start() {
        String userInput = inputView.input();
        if (userInput == null || userInput.isBlank()) {
            outputView.output("0");
        }

        try {
            char delimiter = delimiterExtractor.extractDelimiter(userInput);
        } catch (IllegalArgumentException e) {
            outputView.output(e.getMessage());
        }
    }

}

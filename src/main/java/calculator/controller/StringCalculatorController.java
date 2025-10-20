package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;


public class StringCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public StringCalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;

    }

    public void start() {
        String userInput = inputView.input();
        int result = calculator.calculate(userInput);
        outputView.output(result);
//        try {
//            int result = calculator.calculate(userInput);
//            outputView.output(result);
//        } catch (IllegalArgumentException e) {
//            outputView.printError(e.getMessage());
//        }
    }

}

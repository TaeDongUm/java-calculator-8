package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;

public class StringCalculatorController {

    private final InputView inputView;
    private final Calculator calculator;

    public StringCalculatorController(InputView inputView, Calculator calculator) {
        this.inputView = inputView;
        this.calculator = calculator;
    }

    public void start() {
        String userInput = inputView.input();
    }

}

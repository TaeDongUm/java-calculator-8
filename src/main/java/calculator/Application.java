package calculator;

import calculator.config.AppConfig;
import calculator.controller.StringCalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculatorController calculatorController = AppConfig.createController();
        calculatorController.start();
    }
}

package calculator.view;

public class OutputView {

    public void output(int result) {
        System.out.print("결과 : ");
        System.out.println(result);
    }

    public void printError(String error) {
        System.out.println(error);
    }
}

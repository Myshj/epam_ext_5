package views;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputErrorView extends View {
    private final String warning;


    @Override
    void displayHeader() {
        System.out.println(warning);
    }

    @Override
    void displayBody() {

    }

    @Override
    void displayFooter() {

    }
}

package views;

import java.util.List;

public class MenuView extends PromtingView {

    private final String header;
    private final List<String> choices;


    public MenuView(String HINT, String header, List<String> choices) {
        super(HINT);
        this.header = header;
        this.choices = choices;
    }

    @Override
    void displayHeader() {
        System.out.println(header);
    }

    @Override
    void displayBody() {
        for (int i = 0; i < choices.size(); i++) {
            System.out.print(String.format("%d. ", i + 1));
            System.out.println(choices.get(i));
        }
    }
}

package views;

public class SingleMessageView extends PromtingView {
    private final String HEADER;

    public SingleMessageView(String HEADER, String HINT) {
        super(HINT);
        this.HEADER = HEADER;
    }

    @Override
    void displayHeader() {
        System.out.println(HEADER);
    }

    @Override
    void displayBody() {

    }
}

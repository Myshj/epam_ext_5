package views;

public abstract class PromtingView extends View {
    private static final String PROMT = "> ";

    private final String hint;

    public PromtingView(String hint) {
        this.hint = hint;
    }

    @Override
    void displayFooter() {
        System.out.println(hint);
        System.out.print(PROMT);
    }
}

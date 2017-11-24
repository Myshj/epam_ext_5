package views;

import lombok.AllArgsConstructor;
import utils.Displayable;

@AllArgsConstructor
public abstract class View implements Displayable {
    abstract void displayHeader();

    abstract void displayBody();

    abstract void displayFooter();

    @Override
    public void display() {
        displayHeader();
        displayBody();
        displayFooter();
    }
}

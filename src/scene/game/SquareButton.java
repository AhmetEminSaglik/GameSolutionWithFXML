package scene.game;


import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class SquareButton extends Button {
    private int x, y;
    public  static final String NORMAL_SQUARE_BTN_ID = "SquareBtn";

    public SquareButton(int x, int y) {
        this.x = x;
        this.y = y;
        setId(NORMAL_SQUARE_BTN_ID);
        setPrefSize(40, 40);
        setCursor(Cursor.HAND);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "SquareButton{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

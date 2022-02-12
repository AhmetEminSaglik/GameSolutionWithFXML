package scene.game;


import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class SquareButton extends Button {
    private int x, y;

    public SquareButton(int x, int y) {
        this.x = x;
        this.y = y;
        setId("SquareBtn");
        setPrefSize(40, 40);
        setCursor(Cursor.HAND);
//        setText(x+"-"+y);
//        setStyle();
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
}

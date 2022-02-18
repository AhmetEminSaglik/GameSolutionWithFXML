package fxmlmove;

import scene.game.SquareButton;

import java.util.ArrayList;
import java.util.List;

public class FxmlSquareBtnCommunity {
    public SquareButton[][] squareButtonArray;
    public List<SquareButton> listMovedSquareBtn = new ArrayList<>();
//    private SquareButton currentSquareBtn;

    public SquareButton getCurrentSquareBtn(int x, int y) {
        return squareButtonArray[x][y];
    }

}

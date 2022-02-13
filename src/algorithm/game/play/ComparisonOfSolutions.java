package algorithm.game.play;

import algorithm.game.Game;

public class ComparisonOfSolutions {
    private Game game;
    public CopyModel copyModel;

    public ComparisonOfSolutions(Game game) {
        this.game = game;
        copyModel = new CopyModel();
    }
    public void compareSolution() {
        copyModel.sendModelToCompareAndAddToList(game.getModel());
    }
}

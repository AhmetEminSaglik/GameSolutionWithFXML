package algorithm.game.gamerepo;

public class Model {

    private int gameSquares[][];
    private boolean visitedAreas[][];

    public int[][] getGameSquares() {
        return gameSquares;
    }

    public void setGameSquares(int[][] gameSquares) {
        this.gameSquares = gameSquares;
    }

    public boolean[][] getVisitedAreas() {
        return visitedAreas;
    }

    public void setVisitedAreas(boolean[][] visitedAreas) {
        this.visitedAreas = visitedAreas;
    }


}

package algorithm.game.gamerepo.player.robot.memory;/*
package game.gamerepo.player.robot.memory;

import check.CheckSquare;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.solution.third.Graph;
import game.gamerepo.player.robot.solution.third.Vertex;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;

import java.util.ArrayList;

public class GraphMemory {
    Graph graph;
    Game game;

    int squareEdge;
    ArrayList<DirectionLocation> locationList;
    CheckSquare checkSquare = new CheckSquare();

    public GraphMemory(Game game) {
        graph = new Graph();
        this.game = game;
        squareEdge = game.getModel().getGameSquares().length;
        locationList = new LocationsList().getListOfLocationsAccordingToPlayerCompass();
    }

    public void createGraphAccordingToGame() {
        Location location = new Location();
        for (int j = 0; j < squareEdge; j++) {
            for (int i = 0; i < squareEdge; i++) {
                location.setX(i);
                location.setY(j);
                Vertex vertex = new Vertex(i, j);
                vertex.setAvailableWayNumber(getAvailableWayNumber(location));
                graph.addVertex(new Vertex(i, j));
            }
        }
        graph.printGraph();
        ShowPanel.show(getClass(), "grap YAZDIRILDI");

    }

    public void setconnectionBetweenVertexsInGrap() {*/
/*
        for (Vertex tmpVertex : graph.getGraphMapVertice().keySet())
            for (int j = 0; j < squareEdge; j++) {
                for (int i = 0; i < squareEdge; i++) {
                    if (tmpVertex == new Vertex(i, j)) {

                        for (int k = 0; k < locationList.size() - 1; k++)
                            if (checkSquare.isIndexsSuitableForArray(game, new Location(i, j), locationList.get(k).getId())) {
                                tmpVertex.addConnection();
                            }
                    }
                }
            }*//*



    }


    int getAvailableWayNumber(Location location) {
        int availableWayNumber = 0;
        for (int i = 0; i < locationList.size() - 1; i++) {
            if (checkSquare.isIndexsSuitableForArray(game, location, locationList.get(i).getId()))
                availableWayNumber++;
        }

        return availableWayNumber;
    }
}
*/

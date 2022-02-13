package algorithm.game.gamerepo.player.robot.solution.third;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, HashMap<Vertex, List<Edge>>> graphMapVertice;

    public Graph() {
        graphMapVertice = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        graphMapVertice.put(vertex, new HashMap<>());
    }

    public void removeVertex(Vertex vertex) {
        graphMapVertice.remove(vertex);
    }

    public void setConnectionBetweenTwoVertex(Vertex vertex1, Vertex vertex2) {
        vertex1.addConnection(vertex2);
        vertex2.addConnection(vertex1);
    }

    public void printGraph() {
        System.out.println("Size : " + graphMapVertice.size());
        for (Vertex tmp : graphMapVertice.keySet()) {
            System.out.println(tmp);
            System.out.println("=============");
        }
    }

    public Map<Vertex, HashMap<Vertex, List<Edge>>> getGraphMapVertice() {
        return graphMapVertice;
    }
}

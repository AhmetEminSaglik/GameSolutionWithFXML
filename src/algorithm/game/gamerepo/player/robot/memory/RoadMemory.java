package algorithm.game.gamerepo.player.robot.memory;

import algorithm.game.gamerepo.player.robot.solution.second.exitsituation.ExitSituation;
import algorithm.game.gamerepo.player.robot.solution.second.navigation.Navigation;

import java.util.ArrayList;

public class RoadMemory {
    private ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);
    ArrayList<Navigation> oneWayNumbersList = new ArrayList<Navigation>();

    public ExitSituation getExitSituation() {
        return exitSituation;
    }

    public void updateExistSituation(int situation) {
        this.exitSituation.setSituation(situation);
    }

    public ArrayList<Navigation> getOneWayNumbersList() {
        return oneWayNumbersList;
    }

    public int getLastIndex() {
        return oneWayNumbersList.size() - 1;
    }

    public Navigation getOneWayListLastItem() {
        if (oneWayNumbersList.size() > 0)
            return oneWayNumbersList.get(getLastIndex());
        return null;
    }

    public Navigation removeOneWayListLastItem() {
        return oneWayNumbersList.remove(getLastIndex());
    }
}

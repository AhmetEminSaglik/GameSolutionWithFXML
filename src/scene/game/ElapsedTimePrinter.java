package scene.game;

import algorithm.game.gamerepo.player.robot.TimeKeeper;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class ElapsedTimePrinter extends TimerTask {
    Label lblTimeField;
    TimeKeeper timeKeeper = new TimeKeeper();

    public ElapsedTimePrinter(Label lblTimeField) {
        this.lblTimeField = lblTimeField;
        timeKeeper.startTime();
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            lblTimeField.setText("Elapsed Time : " + timeKeeper.getTotalPassedTimeDuringPlayingGame());
        });
    }

    public String getTimeInStringFormat() {
        return "Elapsed Time : " + timeKeeper.getTotalPassedTimeDuringPlayingGame();
    }
}

package algorithm.game.gamerepo.player.robot;

import algorithm.utility.ConvertNanoTimeToTime;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeKeeper extends TimerTask {
    long start;
    long totalTimePassed;

    public void startTime(){
        start = System.nanoTime();
    }

    public void finishTime() {
        long finish = System.nanoTime() - start;
        totalTimePassed = TimeUnit.MILLISECONDS.convert(finish, TimeUnit.NANOSECONDS);
    }

    public long getTotalTimePassed() {
        return totalTimePassed;
    }

    public String getTotalPassedTimeDuringPlayingGame() {
        finishTime();
        ConvertNanoTimeToTime convertNanoTimeToTime = new ConvertNanoTimeToTime(this);
        return convertNanoTimeToTime.getTimeInStringFormat();
    }


    @Override
    public void run() {
    }
}

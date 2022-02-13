package algorithm.utility;

import algorithm.game.gamerepo.player.robot.TimeKeeper;

public class ConvertNanoTimeToTime {
    TimeKeeper timeKeeper;
    long nanoTime;
    String timeString;
    int second, minute, hour;
    final int ms = 1000;

    public ConvertNanoTimeToTime(TimeKeeper timeKeeper) {
        this.timeKeeper = timeKeeper;
    }

    public String getTimeInStringFormat() {
        nanoTime = timeKeeper.getTotalTimePassed();
        convertToTime();
        return timeString;
    }

    void convertToTime() {
        calculateSecond();
        calculateMinute();
        calculateHour();
        addTimeToStringFormat();
    }

    void calculateSecond() {
        second = (int) (nanoTime / ms);
        nanoTime %= ms;
    }

    void calculateMinute() {
        minute = second / 60;
        second %= 60;

    }

    void calculateHour() {
        hour = minute / 60;
        minute %= 60;
    }

    void addTimeToStringFormat() {
        timeString = hour + ":" + minute + ":" + second + ":" + nanoTime;
    }

}

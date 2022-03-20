package algorithm.game.play.input.robot;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.location.DirectionLocation;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.Move;
import algorithm.game.play.input.PlayerPlayingStyle;
import algorithm.sleep.Sleep;
import javafx.application.Platform;
import javafx.concurrent.Task;
import scene.game.SquareButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RobotPlayingStyle extends PlayerPlayingStyle {
    /*
    esculator servisler
    * */
    int sleepTime = 125;
    Sleep sleep = new Sleep();
    //    private ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {
//        Thread thread = new Thread(r);
//        thread.setDaemon(true);
//        return thread;
//    });
//    static int counter = 1;


    @Override
    public void startGame() {
        game = player.getGame();


        fillFxmlMoveForward();
        fxmlMoveForwardOrBack = fxmlMoveForward;
        fxmlMoveForwardOrBack.setChangePlayerLocation(new ChangeLocationByExactlyLocation(player));
//        System.out.println(fxmlMoveForwardOrBack.getChangePlayerLocation());
        DirectionLocation directionLocation = new DirectionLocation();
        directionLocation.setX(0);
        directionLocation.setY(0);
        fxmlMoveForwardOrBack.move(directionLocation);
        updateChangePlayerLocationFunctionOfFxmlMove(fxmlMoveForward, new ChangeLocationByAdding(player));
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fillFxmlMoveForward();
        fillFxmlMoveBack();

        while (!player.getGameRule().isGameOver(game)) {
//            System.out.println(" -----  >>>  [ while icinde basi ---- >>>" + counter);

//            gameController.executorService.execute(playRobot());
//            if (!isMovementLocked()) {
//                playRobot();
//            }
            if (movementLocked == UNLOCK) {
                playRobot();
//                sleep.sleep(30);
            } else {
//                System.out.print("locked  : " + movementLocked);
//                System.out.println("whiledaa");
                System.out.print("");
            }
//            sleep.sleep(30);
//            System.out.println("locked  : "+isMovementLocked());
//            System.out.println(" -----  >>>  ] while icinde sonu ---- >>>" + counter);
//            counter++;
//            Sleep.s
//            System.out.println(" counter artiriliyor : " + counter);

        }
        /*ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
//            while ((!player.getGameRule().isGameOver(game))) {
//                thread.start();
//            }
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return thread;
        });*/
//        List<Task<Void>> tasks = new ArrayList<>();
//        tasks.add(executorService.ge)
/*
        while (!player.getGameRule().isGameOver(game)) {
//
        executorService.execute(this::playRobot);
        System.out.println("buraya geldi simdi beklicek");
        }*/
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();

//            try {
//                executorService.wait();
//                executorService.notify();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//            try {
//                executorService.wait();
//                executorService.notifyAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
    }
        /*while (!player.getGameRule().isGameOver(game)) {
            try {
                playRobot();
//                playRobot().call();

//                playRobot().wait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/
//    }

    void playRobot() {
//        setMovementLocked(true);
        movementLocked = PlayerPlayingStyle.LOCK;
//        System.out.println(" -----  >>>  (  playRobot Function girdi   ---- >>>  " + counter);
//        System.out.println(" -----  >>>  {  playRobot task ici basi ---- >>> " + counter);

        int choose = player.getInput(game);
        fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
//        fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
        DirectionLocation directionLocationToMove = new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose);
        fxmlMoveForwardOrBack.move(directionLocationToMove);
        checkStatus();
//        try {
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(" -----  >>>  }  playRobot Function girdi---- >>>" + counter);
//        new Sleep().sleep(sleepTime);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {

//            }
//        };
//        return runnable;


    }

    /*synchronized Callable playRobot() {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                int choose = player.getInput(game);
                fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
                fxmlMoveForwardOrBack = getFxmlMoveBackOrForward(choose);
                DirectionLocation directionLocationToMove = new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose);
                fxmlMoveForwardOrBack.move(directionLocationToMove);
                checkStatus();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "buraya ne yazicam bilmiyorum";
            }
        };
        return callable;
    }*/

    public void checkStatus() {
        Runnable runnable = () -> {
            if (prepareGameBySelectingMenu.getPlayer().getStep() == prepareGameBySelectingMenu.getEdgeValue() * prepareGameBySelectingMenu.getEdgeValue()) {
//                Platform.runLater(() -> {
                game.getPlayer().getScore().increaseTotalGameFinishedScore();
                gameController.updateTotalFinishedScore();
//                });

            }
            movementLocked = PlayerPlayingStyle.UNLOCK;
            sleep.sleep(1);
        };

        gameController.runFunctionInPlatformThread(runnable);
    }

//    SquareButton getCurrentSquareBtn() {
//        return squareBtnCommunity.squareButtonArray[player.getLocation().getX()][player.getLocation().getY()];
//    }

    public RobotPlayingStyle(Player player) {
        super(player);
    }

    @Override
    public void play(SquareButton button) {
        System.out.println("robot burada oynicak");
    }

    @Override
    public void stepBack() {
        System.out.println("bu buton calismicak");
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();
        }
        return player.getPlayerMove().getMoveForward();
    }

}

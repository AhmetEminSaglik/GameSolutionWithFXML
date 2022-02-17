package algorithm.Main;

import algorithm.game.Game;
import algorithm.game.gamerepo.BuildGame;
import algorithm.game.gamerepo.IDetermineEdgeValue;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import algorithm.game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import algorithm.game.play.PlayGame;
import algorithm.game.play.input.person.ButtonClickInputForFXML;
import algorithm.game.play.input.person.PersonInput;
import algorithm.game.play.input.person.SafeScannerInput;
import algorithm.game.play.input.robot.RobotInput;

import java.util.Scanner;


public class GameMain implements ISelectPlayer {

    BaseSolution baseSolution;

    public static void main(String[] args) throws InterruptedException {
        GameMain main = new GameMain();
/*
        try {
            openWebpage(new URL("https://www.linkedin.com/in/ahmeteminsaglik"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

//        int squareEdge = 5;
        IDetermineEdgeValue determineValueWithScanner = new IDetermineEdgeValue() {
            @Override
            public int determineEdgeValue() {
                System.out.print("Determine Edge value of Square :  ");
                return new Scanner(System.in).nextInt();
            }
        };

        BuildGame buildGameModel = new BuildGame(determineValueWithScanner);

        Game game = buildGameModel.createGame();

        Player player = main.selectPlayer(game);

        buildGameModel.createVisitedArea();

        PlayGame playGame = new PlayGame(game);
        playGame.playGame();
        System.out.println();

        if (main.baseSolution != null)
            System.out.println(main.baseSolution.getClass().getSimpleName());
        System.out.println("Game Dimension : " + game.getModel().getGameSquares().length + "-" + game.getModel().getGameSquares().length);

      /*  BaseSolution baseSolution2 = new SecondSolution_CalculateForwardAvailableWays(game);
        Player robot2 = new Robot(game, baseSolution2);
        buildGameModel.createVisitedArea();

        PlayGame playGame2 = new PlayGame(game);
        playGame2.playGame();


         comparisonOfSolutions = new ComparisonOfSolutions(game);
        comparisonOfSolutions.deleteBothIfTheyAreSame(playGame.comparisonOfSolutions.copyModel, playGame2.comparisonOfSolutions.copyModel);*/
        System.out.println("----------------");


    }

    public Player selectPlayer(Game game) {
        System.out.println("Select Player : \nPerson : 1 \n Robot : 2");

        String input = new Scanner(System.in).nextLine();
        if (input.equals("1")) {
            Person person = new Person();
            person.setGame(game);
            person.setIPlayerInput(new PersonInput(new ButtonClickInputForFXML(person)));
            System.out.println("game : " + game.toString());
            return person;
//            return new Person(/*game*/);
        } else if (input.equals("2")) {
            Robot robot = new Robot();
            robot.setGame(game);
            baseSolution = new SecondSolution_CalculateForwardAvailableWays(game);
            robot.setSolution(baseSolution);
            robot.buildRobotMove();
            robot.setIPlayerInput(new RobotInput(robot.getSolution()));
            return robot;

//            return new Robot(game, baseSolution);

        } else {
            System.out.println("Unknow choice ");
            return selectPlayer(game);
        }

    }





  /*  public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }*/
}


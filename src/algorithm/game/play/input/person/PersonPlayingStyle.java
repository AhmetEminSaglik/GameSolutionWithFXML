package algorithm.game.play.input.person;

import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;
import algorithm.game.move.Move;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.SelectFirstSqaureToStart;
import algorithm.game.play.input.PlayerPlayingStyle;
import javafx.scene.control.Button;
import scene.game.SquareButton;

import java.util.ArrayList;
import java.util.List;


public class PersonPlayingStyle extends PlayerPlayingStyle {

    Person person;

    //    SquareButton oldSquareBtn;
//    public List<SquareButton> listMovedSquareBtn = new ArrayList<>();


    public PersonPlayingStyle(Player player) {
        super(player);
        person = (Person) player;
    }

    @Override
    public void play(SquareButton button/*int x, int y*/) {

        if (person.getStep() == 0) {
            person.getGame().increaseRoundCounter();
            locatePlayerFirstLocation(button.getX(), button.getY());
            button.setId(CURRENT_BTN_ID);
            button.setText(person.getStep() + "");
//            oldSquareBtn = button;
            listMovedSquareBtn.add(button);
            System.out.println(" listMovedSquareBtn  size: " + listMovedSquareBtn.size());
        } else {
//            listMovedSquareBtn.get(listMovedSquareBtn.size() - 1).setId(VISITED_BEFORE_BTN_ID); // ileri adim atilirsa bu olacak yoksa bu olmayacak
            // geri adim atilirsa da son adimdaki butonu bulup current yapicazcurrent olacak


            if (button.getX() != player.getLocation().getX() || button.getY()!= player.getLocation().getY()) {
//            }
                ButtonClickInputForFXML buttonClickInputForFXML = new ButtonClickInputForFXML(person);
                buttonClickInputForFXML.setLocationToGetCompassDirectionLocation(button.getX(), button.getY());
                PersonInput personInput = new PersonInput(buttonClickInputForFXML);
                player.setIPlayerInput(personInput);

                System.out.println("GELEN DEGER : " + player.getInput(player.getGame()));
                int choose = player.getInput(player.getGame());

                if (choose != -1) {
                    person.getGame().increaseRoundCounter();
                    listMovedSquareBtn.get(listLastIndex()).setId(VISITED_BEFORE_BTN_ID);
                    Move moveForwardOrBack = getMoveBackOrForward(choose);

                    if (moveForwardOrBack != null) {
                        moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(person.getGame(), choose));

                        if (!moveForwardOrBack.getClass().getTypeName().equals(MoveBack.class.getTypeName())) {
                            button.setId(CURRENT_BTN_ID);
                            String text = person.getStep() + "";
                            button.setText(text);
//                        System.out.println("Yazdirilacak deger : " + text);
                            listMovedSquareBtn.add(button);
                            System.out.println(" listMovedSquareBtn  size: " + listMovedSquareBtn.size());


//                        if (person.gameRule.isGameOver(player.getGame())) {
//                            JOptionPane.showMessageDialog(null, " Game Over Step deger i : "+person.getStep());
//                        }
                        } else {
                            listMovedSquareBtn.remove(button);

//                    listMovedSquareBtn.get(listMovedSquareBtn.size()-1).setId(NORMAL_SQUARE_BTN_ID);
//                    listMovedSquareBtn.get(listMovedSquareBtn.size()-1).setText("");
                            button.setId(NORMAL_SQUARE_BTN_ID);
                            button.setText("");
                            listMovedSquareBtn.get(listLastIndex()).setId(CURRENT_BTN_ID);

                        }

                    }
            /*if(moveForwardOrBack.getClass())
                button.setId(CURRENT_BTN_ID);
                button.setText(person.getStep() + "");
                oldSquareBtn = button;*/


                }
            }
        }
    }


    void locatePlayerFirstLocation(int x, int y) {
        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(person.getGame());
        selectFirstSqaureToStart.selectSquareStart(x, y);
        selectFirstSqaureToStart.locateThePlayer();
        System.out.println("Baslangic yeri : secildi" + person.getLocation().toString());
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
//            return player.getPlayerMove().getMoveBack();
            return null;
        }
        return player.getPlayerMove().getMoveForward();
    }

    int listLastIndex() {
        return listMovedSquareBtn.size() - 1;
    }
}

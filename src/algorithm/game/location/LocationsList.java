package algorithm.game.location;


import algorithm.compass.Compass;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.location.direction.*;

import java.util.ArrayList;

public class LocationsList {

    ArrayList<DirectionLocation> list = new ArrayList<>();

    void fillList(Compass compass) {

        list.add(getDirectionLocationWithEmbeddCompass(new North(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new NorthEast(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new East(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new SouthEast(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new South(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new SouthWest(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new West(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new NorthWest(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new LastLocation(), compass));

    }

    DirectionLocation getDirectionLocationWithEmbeddCompass(DirectionLocation directionLocation, Compass compass) {
        directionLocation.setCompass(compass);
        return directionLocation;

    }


    public ArrayList<DirectionLocation> getListOfLocationsAccordingToPlayerCompass(Compass compass) {
        if (list.size() == 0) {
            fillList(compass);
        }
        return list;
    }

    public DirectionLocation getLastLocation(Compass compass) {
        DirectionLocation lastLocation = new LastLocation();
        lastLocation.setCompass(compass);
//        ShowPanel.show(getClass(),"donecek olan lokasyon bilgileri : "+lastLocation.toString());
        return lastLocation;
    }

}

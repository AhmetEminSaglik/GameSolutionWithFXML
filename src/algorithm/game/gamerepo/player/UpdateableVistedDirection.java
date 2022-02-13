package algorithm.game.gamerepo.player;


import algorithm.game.location.DirectionLocation;

public interface UpdateableVistedDirection {

    void updateVisitedDirection(boolean sealOrUnseal,int step, DirectionLocation location);
}

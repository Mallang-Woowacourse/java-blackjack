package model.participator.matchplayerselect;

import model.participator.Player;

public interface MatchPlayerSelectStrategy {
    boolean canSelect(Player player);
}
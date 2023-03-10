package domain.state;

import domain.card.BlackJackScore;
import domain.card.Card;
import domain.card.CardArea;

public interface BlackJackGameStateInterface {

    default boolean hittable() {
        return false;
    }

    default boolean isBust() {
        return false;
    }

    default boolean isBlackJack() {
        return false;
    }

    default BlackJackScore score() {
        throw new UnsupportedOperationException();
    }

    default CardArea cardArea() {
        throw new UnsupportedOperationException();
    }

    default BlackJackGameStateInterface hit(final Card card) {
        throw new UnsupportedOperationException();
    }

    default BlackJackGameStateInterface changeStay() {
        throw new UnsupportedOperationException();
    }
}

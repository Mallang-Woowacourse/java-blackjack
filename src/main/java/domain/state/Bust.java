package domain.state;

import domain.card.CardArea;

public class Bust extends BlackJackGameState {

    protected Bust(final CardArea cardArea) {
        super(cardArea);
    }

    @Override
    public boolean isBust() {
        return true;
    }
}

package domain.state;

import domain.card.BlackJackScore;
import domain.card.CardArea;

public abstract class BlackJackGameState implements BlackJackGameStateInterface {

    protected final CardArea cardArea;

    protected BlackJackGameState(final CardArea cardArea) {
        this.cardArea = cardArea;
    }

    @Override
    public BlackJackScore score() {
        return cardArea.calculate();
    }

    @Override
    public CardArea cardArea() {
        return cardArea;
    }
}

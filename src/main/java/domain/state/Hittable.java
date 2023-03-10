package domain.state;

import domain.card.Card;
import domain.card.CardArea;

public class Hittable extends BlackJackGameState {

    protected Hittable(final CardArea cardArea) {
        super(cardArea);
    }

    @Override
    public BlackJackGameState hit(final Card card) {
        cardArea.addCard(card);
        if (cardArea.isBust()) {
            return new Bust(cardArea);
        }
        if (cardArea.canMoreCard()) {
            return new Hittable(cardArea);
        }
        return new Stay(cardArea);
    }

    @Override
    public BlackJackGameState changeStay() {
        return new Stay(cardArea);
    }
}

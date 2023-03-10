package domain.state;

import domain.card.Card;
import domain.player.BettingMoney;
import domain.player.Revenue;

public interface BlackJackGameStateInterface {

    default BlackJackGameState hit(final Card card) {
        throw new UnsupportedOperationException();
    }

    default Revenue revenue(final BettingMoney bettingMoney) {
        throw new UnsupportedOperationException();
    }

    default BlackJackGameState changeStay() {
        throw new UnsupportedOperationException();
    }
}

package domain.state;

import domain.card.CardArea;
import domain.player.BettingMoney;
import domain.player.Revenue;

public class BlackJack extends BlackJackGameState {

    protected BlackJack(final CardArea cardArea) {
        super(cardArea);
    }

    @Override
    public Revenue revenue(final BettingMoney bettingMoney) {
        return Revenue.blackJackWin(bettingMoney);
    }
}

package domain.state;

import domain.card.CardArea;

public class Initial implements BlackJackGameStateInterface {

    public BlackJackGameState initialDrawTwoCard(final CardArea cardArea) {
        validateSize(cardArea);
        if (cardArea.isBlackJack()) {
            return new BlackJack(cardArea);
        }
        return new Hittable(cardArea);
    }

    private void validateSize(final CardArea cardArea) {
        if (cardArea.cards().size() != 2) {
            throw new IllegalArgumentException("초기 카드는 두장이어야 합니다.");
        }
    }
}

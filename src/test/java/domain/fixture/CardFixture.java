package domain.fixture;

import domain.card.Card;
import domain.card.CardShape;
import domain.card.CardValue;

public class CardFixture {

    public static Card diamond(final CardValue cardValue) {
        return new Card(CardShape.DIAMOND, cardValue);
    }
}

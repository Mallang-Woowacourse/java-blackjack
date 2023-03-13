package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        this(Collections.emptyList());
    }

    public Hand(final List<Card> cards) {
        this.cards = cards;
    }

    public Hand(final Card... cards) {
        this(List.of(cards));
    }

    public Hand add(final Card card) {
        List<Card> cards1 = new ArrayList<>(cards);
        cards1.add(card);
        return new Hand(cards1);
    }

    public Score calculate() {
        final boolean hasAce = hasAce();
        final Score score = score();
        if (hasAce) {
            return score.plusTenIfNotBust();
        }
        return score;
    }

    private Score score() {
        return new Score(cards.stream()
                .mapToInt(Card::score)
                .sum());
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }
}

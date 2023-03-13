package blackjack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Card {

    private static final Map<String, Card> cache = new ConcurrentHashMap<>(52);

    private final Suit suit;
    private final Denomination denomination;

    private Card(
            final Suit suit,
            final Denomination denomination
    ) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(final Suit suit, final Denomination denomination) {
        return cache.computeIfAbsent(toKey(suit, denomination), key -> new Card(suit, denomination));
    }

    private static String toKey(final Suit suit, final Denomination denomination) {
        return suit.name() + denomination.name();
    }

    public int score() {
        return denomination.score();
    }

    public boolean isAce() {
        return denomination.isAce();
    }
}

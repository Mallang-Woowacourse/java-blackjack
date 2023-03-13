package blackjack;

public enum Denomination {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NIGHT(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1),
    ;

    private final int score;

    Denomination(final int score) {
        this.score = score;
    }

    public int score() {
        return score;
    }

    public boolean isAce() {
        return this == ACE;
    }
}

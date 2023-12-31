package domain.card;

public enum CardValue {

    ACE(1),

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),

    KING(10),
    QUEEN(10),
    JACK(10),
    ;

    private final int value;

    CardValue(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isAce() {
        return this == ACE;
    }
}

package blackjack;

public class Score {

    private static final Score aceAdditional = new Score(10);
    private static final Score blackjack = new Score(21);

    private final int value;

    public Score(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Score plusTenIfNotBust() {
        if (add(aceAdditional).isLessThanOrEqual(blackjack)) {
            return add(aceAdditional);
        }
        return this;
    }

    public Score add(final Score score) {
        return new Score(value + score.value);
    }

    public boolean isLessThanOrEqual(final Score score) {
        return value <= score.value;
    }
}

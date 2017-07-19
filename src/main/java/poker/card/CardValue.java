package poker.card;

public enum CardValue {
    _A("A"), _2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), 
    _8("8"), _9("9"), _T("T"), _J("J"), _Q("Q"), _K("K");

    private String text;

    CardValue(String text) {
        this.text = text;
    }

    static CardValue parse(String s) {
        for(CardValue value: CardValue.values()) {
            if (value.text.equals(s)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + s);
    }

    int getCardValue() {
        return this.ordinal();
    }

    @Override
    public String toString() {
        return this.text;
    }
}
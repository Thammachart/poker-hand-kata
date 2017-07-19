package poker.card;

public enum CardValue {
    _A(1, "A"),_2(2, "2"), _3(3, "3"), _4(4, "4"), _5(5, "5"), _6(6, "6"), _7(7, "7"), 
    _8(8, "8"), _9(9, "9"), _T(10, "T"), _J(11, "J"), _Q(12, "Q"), _K(13, "K");

    private int val;
    private String text;

    CardValue(int val, String text) {
        this.val = val;
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
        return this.val;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
package poker.card;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private final CardSuit suit;
    private final CardValue value;

    public static Card parse(String card) {
        return new Card(String.valueOf(card.charAt(0)), String.valueOf(card.charAt(1)));
    }

    public Card(String suit, String value) {
        this(CardSuit.parse(suit), CardValue.parse(value));
    }

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public CardValue getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Card card) {
        return this.value.compareTo(card.value);
    }

    @Override
    public String toString() {
        return this.suit.toString() + this.value.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Card)) {
            return false;
        }

        Card card = (Card) object;
        return  Objects.equals(suit, card.suit) &&
                Objects.equals(value, card.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}

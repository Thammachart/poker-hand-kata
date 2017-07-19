package poker.card;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private final CardSuit suit;
    private final CardValue value;

    public static Card parse(String card) {
        return new Card(card.charAt(0) + "", card.charAt(1) + "");
    }

    public Card(String suit, String value) {
        this(CardSuit.parse(suit), CardValue.parse(value));
    }

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
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
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Card)) {
            return false;
        }
        
        Card card = (Card) o;
        return  Objects.equals(suit, card.suit) &&
                Objects.equals(value, card.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}   
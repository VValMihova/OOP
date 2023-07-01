package WorkingWithAbstraction_01.Exsersice.P03CardsWithPower;


public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private int power;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        return this.cardRank.getPowerRank() + this.cardSuit.getSuitPower();
    }

    public void setPower(int power) {
        this.power = power;
    }
}

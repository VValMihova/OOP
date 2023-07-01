package WorkingWithAbstraction_01.Exsersice.P01CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuit[] values = CardSuit.values();
        for (CardSuit cardSuit : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",cardSuit.ordinal(), cardSuit.name() );
        }
    }
}

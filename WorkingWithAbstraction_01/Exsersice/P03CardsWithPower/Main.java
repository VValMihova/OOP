package WorkingWithAbstraction_01.Exsersice.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();
        Card card = new Card(CardSuit.valueOf(suit), CardRank.valueOf(rank));

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, card.getPower());
    }
}

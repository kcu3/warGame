package L4Part2;
import java.util.ArrayList;
import java.util.Random;

public class main {
    private static ArrayList<card> aa = new ArrayList<>(); // temporary array from which players decks will be generated
    private static ArrayList<card> player1Deck = new ArrayList<>(); // player one deck
    private static ArrayList<card> player2Deck = new ArrayList<>(); // player two deck
    private static ArrayList<card> mainDeck = new ArrayList<>(); // the deck on the table

    // cards of a deck
    private static String rank[] = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    // possible suits
    private static String suit[] = {"spades", "hearts", "diamonds", "clubs"};


    public static void main(String[] args) {
        deckGen(); // generate the deck
        game(); // play the game
    }


    // generate a deck of cards
    public static void deckGen (){
        for(int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 12; i++) {
                card a = new card(suit[j], rank[i], i + 1);
                aa.add(a);


            }
        }

        shuffle(); // shuffle the deck

        // separate the shuffled deck into two equal decks for the players
        for(int i = 0; aa.size() > i; i++){
            if(i < (aa.size() / 2)){
                player1Deck.add(aa.get(i));
            }

            else{
                player2Deck.add(aa.get(i));
            }

        }
    }

    // shuffle deck
    public static void shuffle () {
        // initiate random
        Random random = new Random();
        random.nextInt();

        int a = aa.size();

        for (int i = 0; i < a; i++) {
            // shuffle algorithm

            int change = i + random.nextInt(a - i);
            card element = aa.get(i); // temperary holder
            aa.set(i, aa.get(change));
            aa.set(change, element);
        }

    }

    // sort a deck in case needed (bubble sort)
    public static void sort () {
            for (int i = 0; i < aa.size(); i++)
                for (int j = i + 1; j < aa.size(); j++)
                    if (aa.get(i).getValue() > aa.get(j).getValue()) {
                        card element = aa.get(i);
                        aa.set(i, aa.get(j));
                        aa.set(j, element);
                    }
        }

    // print decks in case needed
    public static void printDeck (ArrayList<card> b){
        int bb = 0;

        for (int i = 0; i < b.size(); i++) {
            System.out.print("Name: " + b.get(i).getSuit() + ";      |  " + "suit: " + b.get(i).getRank() + " " + bb);
            System.out.println();
            bb++;
        }

    }

    // play war
    public static void game (){
        int i = 0;

        // check for win of player 1
        if(player1Deck.size() == 0){
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Player 1 wins!");

        }

        // check for win player 2
        else if(player2Deck.size() == 0){
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Player 2 wins!");

        }

        // in case no winners
        else {
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Compare cards: ");
                System.out.println("Player 1 - " + player1Deck.get(i).getSuit() + " " + player1Deck.get(i).getRank());
                System.out.println("Player 2 - " + player2Deck.get(i).getSuit() + " " + player2Deck.get(i).getRank());


                // if cards are equal
                if (player1Deck.get(i).getValue() == player2Deck.get(i).getValue()) {

                    // check whether the decks are appropriate size to do the operation of adding + 3 to the main deck
                    if(player1Deck.size() >= 3 && player2Deck.size() >= 3) {
                        System.out.println();
                        System.out.println("the cards are the same value so ");
                        System.out.println("+ 4 cards main deck");

                        for (int a = 0; a < 2; a++) {
                            // add cards to the main deck
                            mainDeck.add(player1Deck.get(i));
                            mainDeck.add(player2Deck.get(i));

                            // remove cards from decks of players
                            player1Deck.remove(i);
                            player2Deck.remove(i);
                        }

                        game();

                    }

                    // if the decks of players are not the right size

                    else if (player1Deck.size() < player2Deck.size()){
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.println("Player 1 wins!"); // winner because there are less than 3 cards when there is the same cards on the table

                    }

                    else if (player1Deck.size() > player2Deck.size()){
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.println("Player 2 wins!");// winner because there are less than 3 cards when there is the same cards on the table

                    }

                }

                // if player's one card is bigger
                else if (player1Deck.get(i).getValue() > player2Deck.get(i).getValue()) {
                    System.out.println();
                    System.out.println("Player 1 has a bigger card so ");
                    System.out.println("Player 1 takes the cards");

                    // add cards to the main deck
                    mainDeck.add(player2Deck.get(i));
                    mainDeck.add(player1Deck.get(i));

                    // remove cards from decks of players
                    player2Deck.remove(i);
                    player1Deck.remove(i);

                    // add cards from main deck to the cards of the player who had bigger cards
                    for (int aa = 0; mainDeck.size() > aa; aa++) {
                        player1Deck.add(mainDeck.get(i));
                        mainDeck.remove(i);
                    }


                    game();
                }

                // if player's two card is bigger
                else if (player1Deck.get(i).getValue() < player2Deck.get(i).getValue()) {
                    System.out.println();
                    System.out.println("Player 2 has a bigger card so ");
                    System.out.println("Player 2 takes the cards");

                    // add cards to the main deck
                    mainDeck.add(player2Deck.get(i));
                    mainDeck.add(player1Deck.get(i));

                    // remove cards from decks of players
                    player2Deck.remove(i);
                    player1Deck.remove(i);

                    // add cards from main deck to the cards of the player who had bigger cards
                    for (int aa = 0; mainDeck.size() > aa; aa++) {
                        player2Deck.add(mainDeck.get(i));
                        mainDeck.remove(i);
                    }


                    game();
                }

            }

        }

}

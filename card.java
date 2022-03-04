package L4Part2;

public class card {
    private String suit; // suit of a crd
    private String rank; // rank of a card
    private int value; // what rank does the card has in the game


    // constructor
    public card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;

    }


    // getters and setters
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
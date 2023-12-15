package dblogic;

public class Cards {

    private int player_id;
    private int card_id;
    private int suit_id;
    private int id;

    public void guess() {
    }
    public Cards(int player_id, int card_id, int suit_id) {
        this.player_id = player_id;
        this.card_id = card_id;
        this.suit_id = suit_id;
        this.id = id;

    }

    public int getPlayerId() {
        return player_id;
    }
    public int getId() {
        return id;
    }

    public int getCardId() {
        return card_id;
    }

    public int getSuitId() {
        return suit_id;
    }
}

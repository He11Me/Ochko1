package dblogic;

public class Cards {

    private String player_id;
    private String card_id;
    private String suit_id;
    private int id;

    public void guess() {
    }
    public Cards(String player_id, String card_id, String suit_id) {
        this.player_id = player_id;
        this.card_id = card_id;
        this.suit_id = suit_id;
        this.id = id;

    }

    public String getPlayerId() {
        return player_id;
    }
    public int getId() {
        return id;
    }

    public String getCardId() {
        return card_id;
    }

    public String getSuitId() {
        return suit_id;
    }
}

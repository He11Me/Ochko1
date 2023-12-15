package dblogic;

import java.util.List;
import java.util.Map;

public class CardPersistence {

    private final Database database = Database.getInstance();
    private static final String TABLE_NAME = "ochko";
    private static final String PLAYER_NAME = "player_id";
    private static final String CARD_NAME = "card_id";
    private static final String SUIT_NAME = "suit_id";

    public void putCard(int player_id, int card_id, int suit_id) {
        String sql = """
        insert into ochko.ochko
        (player_id, card_id, suit_id)
        values
        ('%d', '%d', '%d')
        """;
        database.execute(String.format(sql, player_id, card_id, suit_id));
    }

    protected Cards convertCard(Map<String, Integer> fromBd) {
        return new Cards(
                fromBd.get(PLAYER_NAME),
                fromBd.get(CARD_NAME),
                fromBd.get(SUIT_NAME)
        );
    }

    public List<Cards> getAll() {
        List<Map<String, Integer>> fromDB = database.selectAll(
                PLAYER_NAME,
                CARD_NAME,
                SUIT_NAME
        );

        return fromDB.stream()
                .map(this::convertCard)
                .toList();
    }
}

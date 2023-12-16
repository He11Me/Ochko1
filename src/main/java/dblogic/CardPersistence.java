package dblogic;

import java.util.List;
import java.util.Map;

public class CardPersistence {

    private static final Database database = Database.getInstance();
    private static final String PLAYER_NAME = "player_id";
    private static final String CARD_NAME = "card_id";
    private static final String SUIT_NAME = "suit_id";

    public void putCard(String player_id, String card_id, String suit_id) {
        String sql = """
        insert into ochko.ochko
        (player_id, card_id, suit_id)
        values
        ('%d', '%d', '%d')
        """;
        database.execute(String.format(sql, player_id, card_id, suit_id));
    }

    public void updateById(int id, Map<String, Integer> values) {
        database.updateById(id, values);
    }

    public static Cards convertCard(Map<String, String> fromBd) {
        return new Cards(
                fromBd.get(PLAYER_NAME),
                fromBd.get(CARD_NAME),
                fromBd.get(SUIT_NAME)
        );
    }

    public static Cards getById(int id) {
        Map<String, String> fromBd = database.selectById(id, PLAYER_NAME, CARD_NAME, SUIT_NAME);
        if (fromBd == null && fromBd.isEmpty())
            return convertCard(fromBd);
        return null;
    }

    public void deleteById(int id) {
        database.deleteById(id);
    }

    public void deleteAll() {
        database.clear();
    }

    public List<Cards> getAll() {
        List<Map<String, String>> fromDB = database.selectAll(PLAYER_NAME, CARD_NAME, SUIT_NAME);
        return fromDB.stream()
                .map(CardPersistence::convertCard)
                .toList();
    }
}

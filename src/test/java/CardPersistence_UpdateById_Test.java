import dblogic.CardPersistence;
import dblogic.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistence_UpdateById_Test {
    private final CardPersistence cardPersistence = new CardPersistence();
    @Test
    @DisplayName("update method is passed")
    public void updateTest() {
        cardPersistence.putCard("1", "5", "2");

        Map<String, Integer> values = new HashMap<>();

        values.put("player_id", 1);
        values.put("card_id", 5);
        values.put("suit_id", 2);
        cardPersistence.updateById(1, values);

        Cards сard = CardPersistence.getById(1);
        then(сard).isNotNull();
        then(сard.getId()).isEqualTo(1);
        then(сard.getPlayerId()).isEqualTo(1);
        then(сard.getCardId()).isEqualTo(5);
        then(сard.getSuitId()).isEqualTo(2);
    }
}
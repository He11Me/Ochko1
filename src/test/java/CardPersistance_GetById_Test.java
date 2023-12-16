import dblogic.CardPersistence;
import dblogic.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistance_GetById_Test {
    private final CardPersistence cardPersistence = new CardPersistence();
    @Test
    @DisplayName("getById method is passed")
    public void getByIdTest() {
        Cards card = cardPersistence.getById(1);
        then(card).isNotNull();
        then(card.getId()).isEqualTo(1);
        then(card.getPlayerId()).isEqualTo(1);
        then(card.getCardId()).isEqualTo(5);
        then(card.getSuitId()).isEqualTo(2);
    }
}
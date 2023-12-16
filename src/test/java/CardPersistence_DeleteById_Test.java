import dblogic.CardPersistence;
import dblogic.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistence_DeleteById_Test {
    private final CardPersistence cardPersistence = new CardPersistence();
    @Test
    @DisplayName("deleteById method is passed")
    public void deleteByIdTest() {
        cardPersistence.putCard("1", "6", "1");
        cardPersistence.putCard("1", "3", "2");
        cardPersistence.deleteById(1);

        Cards card = cardPersistence.getById(1);
        then(card.getId()).isNull();
        then(card.getPlayerId()).isNull();
        then(card.getCardId()).isNull();
        then(card.getSuitId()).isNull();

        Cards card2 = cardPersistence.getById(2);
        then(card).isNotNull();
        then(card.getId()).isEqualTo(1);
        then(card2.getCardId()).isEqualTo(3);
        then(card2.getSuitId()).isEqualTo(2);

    }
}
import dblogic.CardPersistence;
import dblogic.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistence_DeleteAll_Test {
    private final CardPersistence cardPersistence = new CardPersistence();
    @Test
    @DisplayName("deleteAll method is passed")
    public void deleteAllTes() {
        cardPersistence.putCard("1", "6", "1");
        cardPersistence.putCard("1", "3", "2");
        cardPersistence.deleteAll();

        Cards card = cardPersistence.getById(1);
        then(((Cards) card).getId()).isNull();
        then(card.getPlayerId()).isNull();
        then(card.getCardId()).isNull();
        then(card.getSuitId()).isNull();

        Cards card2 = cardPersistence.getById(2);
        then(card.getId()).isNull();
        then(card2.getPlayerId()).isNull();
        then(card2.getCardId()).isNull();
        then(card2.getSuitId()).isNull();
    }
}
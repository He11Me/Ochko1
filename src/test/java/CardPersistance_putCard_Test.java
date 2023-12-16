import dblogic.CardPersistence;
import dblogic.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistance_putCard_Test {
    private final CardPersistence сardPersistence = new CardPersistence();

    @Test
    @DisplayName("putCard method is passed")
    public void pusTes() {

        сardPersistence.putCard("1", "5", "2");
        Cards сard = CardPersistence.getById(1);
        then(сard).isNotNull();
        then(сard.getId()).isEqualTo(1);
        then(сard.getPlayerId()).isEqualTo(1);
        then(сard.getCardId()).isEqualTo(5);
        then(сard.getSuitId()).isEqualTo(2);
    }
}
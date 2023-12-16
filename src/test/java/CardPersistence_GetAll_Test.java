import dblogic.CardPersistence;
import dblogic.Cards;
import gamelogic.Consts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CardPersistence_GetAll_Test {
    private final CardPersistence cardPersistence = new CardPersistence();
    @Test
    @DisplayName("getAll method is passed")
    public void getAllTest() {
        cardPersistence.putCard("1", "6", "1");
        cardPersistence.putCard("1", "3", "2");
        cardPersistence.putCard("0", "8", "3");
        List<Cards> all = cardPersistence.getAll();
        then(all.size()).isEqualTo(3);
        then(all.get(0).getId()).isEqualTo(1);
        then(all.get(0).getPlayerId()).isEqualTo(1);
        then(all.get(0).getCardId()).isEqualTo(6);
        then(all.get(0).getSuitId()).isEqualTo(1);

        then(all.get(0).getId()).isEqualTo(Consts.TWO);
        then(all.get(0).getPlayerId()).isEqualTo(1);
        then(all.get(0).getCardId()).isEqualTo(3);
        then(all.get(0).getSuitId()).isEqualTo(2);

        then(all.get(0).getId()).isEqualTo(Consts.THREE);
        then(all.get(0).getPlayerId()).isEqualTo(0);
        then(all.get(0).getCardId()).isEqualTo(8);
        then(all.get(0).getSuitId()).isEqualTo(3);
    }
}
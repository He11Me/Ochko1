import dblogic.CardPersistence;
import dblogic.Cards;

import java.util.Map;
import java.util.Objects;

import static dblogic.CardPersistence.convertCard;

public class CardPersistence_Convert_Test {
    private static final CardPersistence cardPersistence = new CardPersistence();
    public static void main(String[] args) {
        Map<String, String> input = Map.of(
                "1", "6", "1",
                "1", "3", "2"
        );
        Cards card = convertCard(input);
        if (!Objects.equals(card.getPlayerId(), 1)) {
            throw new RuntimeException(
                    "Invalid. Actual infl: " + card.getPlayerId()
            );
        }
        if (!Objects.equals(card.getCardId(), 6)) {
            throw new RuntimeException(
                    "Invalid. Actual infl: " + card.getCardId()
            );
        }
        if (!Objects.equals(card.getSuitId(), 1)) {
            throw new RuntimeException(
                    "Invalid. Actual infl: " + card.getSuitId()
            );
        }
    }
}
package gamelogic;

import dblogic.Database;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CardsProcessing extends JLabel {

    private static int score;
    private static int scorePc;
    CardsForming cardsForming = new CardsForming();
    Database db = new Database();

    public CardsProcessing( ) {
        view();
    }

    public void scoreCalc( ) {

        score = 0;
        scoreCalculation(score, Consts.ONE);
    }

    public void scoreCalcPc( ) {

        scorePc = 0;
        scoreCalculation(scorePc, Consts.ZERO);
    }

    public void scoreCalculation(int scoreOfPlayer, int number){

        List<Map<String, Integer>> result = db.selectAll();
        for (Map<String, Integer> maps : result) {
            for (String key: maps.keySet()) {
                if (key.equals("player_id")) {
                    if (maps.get("player_id") == number) {

                        switch (maps.get("card_id")) {
                            case Consts.ZERO -> scoreOfPlayer += Consts.SIX;
                            case Consts.ONE -> scoreOfPlayer += Consts.SEVEN;
                            case Consts.TWO -> scoreOfPlayer += Consts.EIGHT;
                            case Consts.THREE -> scoreOfPlayer += Consts.NINE;
                            case Consts.FOUR -> scoreOfPlayer += Consts.TEN;
                            case Consts.FIVE -> scoreOfPlayer += Consts.TWO;
                            case Consts.SIX -> scoreOfPlayer += Consts.THREE;
                            case Consts.SEVEN -> scoreOfPlayer += Consts.FOUR;
                            case Consts.EIGHT -> scoreOfPlayer += Consts.ELEVEN;
                        }
                    }
            }
        }
    }
}

    public void restartGame() {
/*        for (int i = 0; i < gamelogic.CardsForming.CardsPc.size(); i++) {
            gamelogic.CardsForming.CardsPc.remove(i);
        }
        for (int i = 0; i < gamelogic.CardsForming.Cards.size(); i++) {
            gamelogic.CardsForming.Cards.remove(i);
        }
        scorePc = 0;
        score = 0;
        view();
 */
    }

    public void cardsOfPlayer( ) {
        cardsForming.checkCard(CardsForming.CardsPc, CardsForming.Cards,
                cardsForming.createRandomCard());
        scoreCalc(CardsForming.Cards);
        view();
    }

    public void scoreOfPlayers() {
        while (true) {
            if (scorePc <= 16) {
                cardsForming.checkCard(CardsForming.Cards, CardsForming.CardsPc,
                        cardsForming.createRandomCard());
                scoreCalcPc(CardsForming.CardsPc);
            } else {
                break;
            }
        }
        view();
    }

    public void getWinner() {
        if ((score > scorePc && score <= Consts.COUNT_FOR_WIN) ||
                (scorePc > Consts.COUNT_FOR_WIN && score <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Вы победили!");
        } else if ((scorePc > score && scorePc <= Consts.COUNT_FOR_WIN) ||
                (score > Consts.COUNT_FOR_WIN && scorePc <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Вы проиграли!");
        } else {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Ничья!");
        }
    }

    public void view() {
        setText("Ваши очки: " + score + "\n Очки противника: " + scorePc);
    }
}

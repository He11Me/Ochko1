package gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsForming {

    Random random = new Random();
    public static List<int[]> Cards = new ArrayList<int[]>();
    public static List<int[]> CardsPc = new ArrayList<int[]>();

    public CardsForming( ) {
        createRandomCard();
    }

    public int[] createRandomCard( ) {

        int card = random.nextInt(Consts.COUNT_OF_CARS);
        int suit = random.nextInt(Consts.COUNT_OF_SUITS);
    }

    public void checkCard(List<int[]> Cards, List<int[]> CardsNew, int[] arr) {
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;

        if (Cards.isEmpty()) {
            Cards.add(new int[] {-1,-1});
        }
        if (CardsNew.isEmpty()) {
            CardsNew.add(new int[] {-1,-1});
        }

        for (int[] card : Cards) {
            if (card[0] == arr[0] && card[1] == arr[1]) {
                flag1 = false;
                break;
            }
        }

        if (flag1) {

            for (int[] cardN : CardsNew) {
                if (cardN[0] == arr[0] && cardN[1] == arr[1]) {
                    flag2 = false;
                    break;
                }
            }
        }
        if (flag2) {
            CardsNew.add(new int[]{arr[0], arr[1]});
            flag = false;
        }

        if (flag) {
            checkCard(Cards, CardsNew, createRandomCard());
        }
    }
}



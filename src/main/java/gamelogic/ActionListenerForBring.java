package gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerForBring implements ActionListener {

    private CardsProcessing label;

    public ActionListenerForBring(CardsProcessing label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.cardsOfPlayer();
        label.cardsOfPc();
    }
}


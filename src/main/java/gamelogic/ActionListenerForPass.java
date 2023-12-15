package gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerForPass implements ActionListener {

    private CardsProcessing label;

    public ActionListenerForPass(CardsProcessing label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.scoreOfPlayers();
        label.getWinner();
    }
}

package gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerForRestart implements ActionListener {

    private CardsProcessing label;

    public ActionListenerForRestart(CardsProcessing label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.restartGame();
    }
}

package gamelogic;

import dblogic.Database;
import dblogic.CardPersistence;
import javax.swing.*;
import java.awt.*;

public class CountScoreCalc extends JFrame {

    private JPanel panel = new JPanel();

    public CountScoreCalc( ) {
        super("Score calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(Consts.THOUSAND, Consts.SEVEN_HUNDRED));
        this.setLocation(Consts.FIVE_HUNDRED, Consts.TWO_HUNDRED);

        CardsProcessing cardsProcessing = new CardsProcessing();
        CardPersistence cards = new CardPersistence();
        JButton bring = new JButton("Взять карту");
        JButton pass = new JButton("Пасс");
        JButton restart = new JButton("Начать заново");

        panel.setLayout(new BorderLayout());
        panel.add(cardsProcessing, BorderLayout.NORTH);
        panel.add(bring, BorderLayout.WEST);
        panel.add(pass, BorderLayout.EAST);
        panel.add(restart, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.CENTER);

        bring.addActionListener(new ActionListenerForBring(cardsProcessing));
        pass.addActionListener(new ActionListenerForPass(cardsProcessing));
        restart.addActionListener(new ActionListenerForRestart(cardsProcessing));
    }
}

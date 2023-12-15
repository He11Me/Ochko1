package gamelogic;

import gamelogic.CountScoreCalc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        CountScoreCalc calculator = new CountScoreCalc();
        calculator.setVisible(true);
        calculator.pack();
    }
}
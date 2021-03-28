package game;

import game.Games.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends javax.swing.JPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private JLabel lblScoreValue;
    private JLabel lblName;
    private Game game;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ControlPanel(Game game) {

        this.game = game;


        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
                System.out.println("Game Paused");

            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game Restarted");


            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }
}





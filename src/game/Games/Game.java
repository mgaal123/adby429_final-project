/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */


package game.Games;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import game.ControlPanel;
import game.Controller;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel level;


    private GameView view;


    private Controller controller;

    private int sausageCount;


    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = new Level1(this);
        // make a view
        // make a view

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        try {
            SoundClip gameMusic = new SoundClip("data/gamemusic.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        view = new GameView(level, level.getMan(), this, 490, 490);
        view.setZoom(20);
        // add some mouse actions
        // add this to the view, so coordinates are relative to the view

        // world.addStepListener(new Tracker(view, world.getStudent()));

        // add the view to a frame (Java top level window)
       // final JFrame frame = new JFrame("Basic world");
       // frame.add(view);
        final JFrame frame = new JFrame("FINAL GAME adby429");
        frame.add(view);

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.WEST);

        //make another view and add it at the bottom of the frame
        UserView wideView = new UserView(level, 400, 100);
        wideView.setZoom(4);
        frame.add(wideView, BorderLayout.SOUTH);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);


        frame.addKeyListener(new Controller(level.getMan()));

        controller = new Controller(level.getMan());
        frame.addKeyListener(controller);
        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(level, 500, 500);

        // start our game world simulation!
        level.start();
    }

    public void goToNextLevel() {

        if (level instanceof Level1) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            System.out.println(" Level 2");
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateMan(level.getMan());
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level2) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            System.out.println(" Level 3");
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateMan(level.getMan());
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level3) {
            System.out.println("you wonnnn!");
            System.exit(0);
        }

    }

    public int getSausageCount() {
        return sausageCount;
    }

    public int addSausageCount() {
        return sausageCount++;
    }


    /**
     * Run the game.
     */
    public static void main(String[] args) {


        new Game();
    }


    public String getWorld() {
        return (getWorld());
    }


    public void pause() {
    }
}






























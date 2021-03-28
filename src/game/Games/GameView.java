
/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */

package game.Games;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Characters.Man;

import javax.swing.*;
import java.awt.*;



public class GameView extends UserView {
    private Image background;
    private Man man;
    private Game game;


    /**
     * the view of the game
     * <p>
     * the view of the game including characters, background images, scores and lives
     *
     * @param  world the world, man is the character, game is the game, width and height is the coordinates/vertcies
     * @return nothing
     */
    public GameView(World world, Man man, Game game, int width, int height) {
        super(world, width, height);
        this.man = man;
        this.game = game;


        this.background = new ImageIcon("data/background.png").getImage();
    }



    /**
     * the Details of the background including the score and the font
     */
    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, -20, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("score:" + man.getSausageCount(), 10, 20);
        g.drawString("Lives:" + man.getLifeCount(), 100, 20);

       // public void updateMan(Man man)
       // {this.man=man;}




    }
}

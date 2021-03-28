
/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */


package game.Games;

import city.cs.engine.*;
import game.Characters.Crocodile;
import game.Characters.Door;
import game.Characters.Man;
import game.Characters.Sausage;
import game.Pickup;
import org.jbox2d.common.Vec2;





/**
 * shows us the game world
 * <p>
 * shows us the details of each game world and what characters are inside it
 *
 * @param , crocodile, door the positonings of all the characters within the game
 * @return nothing
 */
public class GameWorld extends World {

    private Man man;
    private Crocodile crocodile;
    private Door door;



    public GameWorld() {

        // make the ground
        Shape shape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.25f));

        // border
        Shape platform1Shape = new BoxShape(1, 25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-13, -12.5f));

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(13, -12f));

        //stairs
        Shape platform3Shape = new BoxShape(2, 1f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(-5, -11f));


        man = new Man(this);
        man.setPosition(new Vec2(-11, -10));

        door = new Door(this);
        door.setPosition(new Vec2(11, -4));

        crocodile = new Crocodile(this);
        crocodile.setPosition(new Vec2(2, -10));
        crocodile.addCollisionListener(new Pickup(man));

        for (int i = 0; i < 8; i++) {
            Body sausage= new Sausage(this);
            sausage.setPosition(new Vec2(i*2-6, 9));
            sausage.addCollisionListener(new Pickup(man));

        }
    }

    public Man getMan() {
        return man;
    }

}

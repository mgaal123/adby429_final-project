/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */


package game.Games;

import city.cs.engine.World;
import game.Characters.Crocodile;
import game.Characters.Door;
import game.Characters.Man;
import game.DoorEncounter;
import game.Pickup;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    private Man man;
    private Crocodile crocodile;
    private Door door;
    /**
     * shows us the details of each game level
     * <p>
     * shows us the details of each game level, such as the positioning of the characters
     *
     * @param  game the positonings of all the characters within the game
     * @return nothing
     */

    public GameLevel(Game game) {

/**
 * positoning of all characters
 */


        man = new Man(this);
        man.setPosition(new Vec2(-11, -10));
        crocodile = new Crocodile(this);
        crocodile.setPosition(new Vec2(1, -10));
      door = new Door(this);
        door.setPosition(new Vec2(12, 4));


      crocodile.addCollisionListener(new Pickup(man));
      DoorEncounter encounter = new DoorEncounter(this, game);
      man.addCollisionListener(encounter);
    }



    /**
     * returning of the fields of the characters
     */
    public Man getMan(){
        return man;
    }
    public Crocodile getCrocodile() { return crocodile;}
    public Door getDoor() {return door; }


    public abstract boolean isComplete();



}

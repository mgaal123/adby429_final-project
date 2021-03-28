/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */



package game.Characters;


import city.cs.engine.*;

public class Door extends Walker { private static final Shape doorShape = new PolygonShape(-1.15f,2.43f, 1.06f,2.43f, 0.98f,-2.32f, -1.04f,-2.33f, -1.15f,2.43f);

    private static final BodyImage image =
            new BodyImage("data/door.png", 4f);


    public Door(World world) {
        super(world, doorShape);
        addImage(image);

    }

}



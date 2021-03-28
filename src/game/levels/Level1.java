package game.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.*;
import game.Characters.Sausage;
import game.Games.Game;
import game.Games.GameLevel;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1  extends GameLevel implements ActionListener {

    private static final int NUM_SAUSAGE = 1;



    public Level1(Game game) {
        //the base class will create the student, professor
        //and the ProfessorEncounter

        super(game);

        //we still need to set the positions of the student
        //and professor

        getMan().addCollisionListener(new SausagePickup(getMan()));
        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class


        // make the ground
        Shape shape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // border
        Shape platform1Shape = new BoxShape(1, 25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-13, -12.5f));

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(13, -12f));

        Shape platform3Shape = new BoxShape(3, 2f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(11, -6f));

        Shape platform4Shape = new BoxShape(1, 5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-5, -12f));

        Shape platform5Shape = new BoxShape(1, 7f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(5, -12f));




        for (int i = 0; i < 9; i++) {
            Sausage sausage = new Sausage(this);
            sausage.setPosition(new Vec2(i * 3-6, 10));
            sausage.addCollisionListener(new Pickup(getMan()));
        }

    }







    @Override
    public boolean isComplete() {
        return getMan().getSausageCount() >= NUM_SAUSAGE;


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




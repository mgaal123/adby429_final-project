package game.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.*;
import game.Characters.Sausage;
import game.Games.Game;
import game.Games.GameLevel;
import org.jbox2d.common.Vec2;


    public class Level3  extends GameLevel {

        private static final int NUM_SAUSAGE = 3;

        public Level3(Game game) {
            //the base class will create the student, professor
            //and the ProfessorEncounter
            super(game);

            //we still need to set the positions of the student
            //and professor

            //we're setting up BooksPickup here though we could
            //also add it to the GameLevel class
            getMan().addCollisionListener(new SausagePickup(getMan()));

            // make the ground
            Shape shape = new BoxShape(25, 0.5f);
            StaticBody ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0f, -12.5f));

            // border
            Shape platform1Shape = new BoxShape(1, 25f);
            StaticBody platform1 = new StaticBody(this, platform1Shape);
            platform1.setPosition(new Vec2(-13, -12.5f));

            StaticBody platform2 = new StaticBody(this, platform1Shape);
            platform2.setPosition(new Vec2(13, -12f));

            //Shape platform3Shape = new BoxShape(1, 1f);
            //StaticBody platform3 = new StaticBody(this, platform3Shape);
            //platform3.setPosition(new Vec2(-8, -12f));

            Shape platform4Shape = new BoxShape(1, 2f);
            StaticBody platform4 = new StaticBody(this, platform4Shape);
            platform4.setPosition(new Vec2(-5, -12f));

            Shape platform5Shape = new BoxShape(1, 6f);
           StaticBody platform5 = new StaticBody(this, platform5Shape);
            platform5.setPosition(new Vec2(1, -12f));

            Shape platform7Shape = new BoxShape(1, 2f);
            StaticBody platform7 = new StaticBody(this, platform7Shape);
            platform7.setPosition(new Vec2(7, -5f));


            //stairs
            Shape platform6Shape = new BoxShape(4, 1f);
            StaticBody platform6 = new StaticBody(this, platform6Shape);
            platform6.setPosition(new Vec2(10, -4f));

            Shape platform8Shape = new BoxShape(4, 1f);
            StaticBody platform8 = new StaticBody(this, platform8Shape);
            platform8.setPosition(new Vec2(-2, -11f));

            Shape platform9Shape = new BoxShape(3, 1f);
            StaticBody platform9 = new StaticBody(this, platform9Shape);
            platform9.setPosition(new Vec2(-7, -5f));

            Shape platform10Shape = new BoxShape(2, 1f);
            StaticBody platform10 = new StaticBody(this, platform10Shape);
            platform10.setPosition(new Vec2(0, 1f));

            Shape platform11Shape = new BoxShape(1, 1f);
            StaticBody platform11 = new StaticBody(this, platform11Shape);
            platform11.setPosition(new Vec2(7, 3f));


            Shape platform12Shape = new BoxShape(1, 1f);
            StaticBody platform12 = new StaticBody(this, platform11Shape);
            platform12.setPosition(new Vec2(11, 3f));

            Shape platform13Shape = new BoxShape(1, 1f);
            StaticBody platform13 = new StaticBody(this, platform11Shape);
            platform13.setPosition(new Vec2(-2, 2f));

            for (int i = 0; i < 6; i++) {
                Sausage sausage = new Sausage(this);
                sausage.setPosition(new Vec2(i * 3-6, 10));
                sausage.addCollisionListener(new Pickup(getMan()));

            }

        }


        @Override
        public boolean isComplete() {
            return getMan().getSausageCount() >= NUM_SAUSAGE;

        }

    }


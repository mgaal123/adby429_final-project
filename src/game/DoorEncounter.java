package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Door;
import game.Games.Game;
import game.Games.GameLevel;


public class DoorEncounter implements CollisionListener {


        private GameLevel level;
        private Game game;

       public DoorEncounter(GameLevel level, Game game) {
           this.level = level;
           this.game = game;
       }

        @Override
        public void collide(CollisionEvent e) {


            if (e.getOtherBody() instanceof Door){
                 System.out.println("got here");
          //  if (e.getOtherBody() instanceof Door
           //         && level.isComplete()) {
                level.isComplete();
               game.goToNextLevel();


            }
        }
    }




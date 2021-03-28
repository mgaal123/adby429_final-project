package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Characters.Crocodile;
import game.Characters.Man;
import game.Characters.Sausage;

public class Pickup implements CollisionListener {

    private Man man;

    public Pickup(Man man) {
        this.man = man;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Sausage && e.getOtherBody() == man) {
            man.incrementSausageCount();
            e.getReportingBody().destroy();
        } else if (e.getReportingBody() instanceof Crocodile && e.getOtherBody() == man) {
            man.decrementLifeCount();
            e.getReportingBody().destroy();
        }
    }
}
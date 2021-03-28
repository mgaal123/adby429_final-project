package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Characters.Man;
import game.Games.GameView;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Man man;
    public Tracker(GameView view, Man man) {
        this.view = view;
        this.man = man;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(man.getPosition()));
    }
}
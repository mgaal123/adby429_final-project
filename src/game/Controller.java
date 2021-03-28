package game;

import city.cs.engine.Walker;
import game.Characters.Man;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private static final float WALKING_SPEED = 5;
    private static final float JUMPING_SPEED = 11;

    private Walker body;


    public Controller(Walker body) {
        this.body = body;
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W) {
            Vec2 v = body.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }

    }

    public void updateMan(Man man) {
        this.body = man;}
    }


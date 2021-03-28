/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */


package game.Characters;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Crocodile extends Walker {
    private static final Shape crocodileShape = new PolygonShape(-0.2f, 2.04f, 1.74f, 0.97f, 0.21f, -1.89f, -1.22f, -1.59f, -1.23f, 1.5f);

    private static SoundClip crocodileSound;


    static {
        try {
            crocodileSound = new SoundClip("data/crocodileSound.wav");
        } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
            unsupportedAudioFileException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (LineUnavailableException lineUnavailableException) {
            lineUnavailableException.printStackTrace();
        }

    }


    private static final BodyImage image = new BodyImage("data/crocodile.png", 3F);

    public Crocodile(World world) {
        super(world, crocodileShape);
        addImage(image);

    }

    @Override
    public void destroy() {

        crocodileSound.play();
        super.destroy();

    }
}



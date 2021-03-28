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

public class Sausage extends DynamicBody {

    private static final Shape booksShape = new CircleShape(1);


    private static SoundClip sausageSound;

    static {
        try {
            sausageSound = new SoundClip("data/sausageSound.wav");
        } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
            unsupportedAudioFileException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (LineUnavailableException lineUnavailableException) {
            lineUnavailableException.printStackTrace();
        }

    }


    private static final BodyImage image =
            new BodyImage("data/sausage.png", 1f);

    public Sausage(World w) {
        super(w, booksShape);
        addImage(image);

    }

    @Override
    public void destroy() {

        sausageSound.play();
        super.destroy();
    }
}




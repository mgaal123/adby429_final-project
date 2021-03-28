/**
 * @author      Mohammed Ga'Al
 * @version     3.0
 * @since       28/03/2021
 */



package game.Characters;

import city.cs.engine.*;



public class Man extends Walker {
    private static final Shape manShape = new PolygonShape(-0.2f, 2.04f, 1.74f, 0.97f, 0.21f, -1.89f, -1.22f, -1.59f, -1.23f, 1.5f);

    private static final BodyImage image =
            new BodyImage("data/man.png", 3F);

    private int lifeCount;

    /**
     * shows us the details of the character man
     * <p>
     * shows us the details of the character man, including the lives he has and the amount of sausages he starts off with
     *
     * @param  world the positonings of man in the game
     * @return nothing
     */

    public Man(World world) {
        super(world, manShape);
        addImage(image);

        lifeCount = 3;
        sausageCount = 0;
    }


    /**
     * details of the count of lives and sausages
     */
    private int sausageCount;

    public int getLifeCount() {
        return lifeCount;
    }



    public void decrementLifeCount() {
        lifeCount--;
        System.out.println("AHHH YOUVE BEEN BITTEN. LIVES LEFT " +
                lifeCount);

        sausageCount = 0;

    }

        public void incrementSausageCount() {
            sausageCount++;
            System.out.println("congrats: " +
                    "sausage count = " + sausageCount);
        }


    public int getSausageCount() {
        return sausageCount;
    }
    }



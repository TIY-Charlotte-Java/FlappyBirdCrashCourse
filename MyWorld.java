import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int actCount = 0;
    private int score = 0;
    private Actor flappy = new FlappyBird();
    private static GreenfootImage gameOver = new GreenfootImage("images/game_over.png");
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        addObject(flappy, 50, getHeight() / 2);
    }
    
    public void act() {
        // 34 is totally arbitrary. lower to increase pipe
        // rate, increase to lower pipe rate.
        if (actCount == 34) {
            actCount = 0;
            
            createTubePair();
        }
        
        if (detectCollisions()) {
            endGame();
        }
        
        actCount = actCount + 1;
    }
    
    private void endGame() {
        addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
        
        showText("Your score: " + score, getWidth() / 2, (getHeight() / 2) + 30);
        Greenfoot.stop();
    }
    
    private boolean detectCollisions() {
        if (flappy.isAtEdge() || ((FlappyBird)flappy).touchesPipes()) {
            return true;
        }
        
        return false;
    }

    private void createTubePair() {
        int offset = Greenfoot.getRandomNumber(50);
        
        if (Math.random() > .5) {
            offset = -offset;
        }
        
        addObject(new TopTube(), getWidth(), -15 + offset);
        addObject(new BottomTube(), getWidth(), getHeight() + 15 + offset);
    }

    
    public void increaseScore() {
        score++;
    }
}

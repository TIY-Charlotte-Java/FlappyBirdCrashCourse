import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    int velocity = 0;
    private boolean jumping = false;
    private static final int MAX_VELOCITY = 15;
    
    public boolean touchesPipes() {
        return isTouching(Tube.class);
    }
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            if (!jumping) {
                jumping = true;
                velocity = -MAX_VELOCITY;
            }
        } else {
            jumping = false;
        }
        
        if (velocity < MAX_VELOCITY) {
            velocity = velocity + 1;
        }
        
        setRotation();
        
        setFlappyImage();
        
        // Add your action code here.
        setLocation(getX(), getY() + velocity);
    }
    
    private void setRotation() {
        final int MAX_DEGREE = 60;
        
        int absVelocity = Math.abs(velocity);
        double percentage = absVelocity / (double)MAX_VELOCITY;
        int angle = (int)(percentage * MAX_DEGREE);
        
        if (velocity > 0) {
            setRotation(angle);
        } else {
            setRotation(-angle);
        }
    }
    
    private void setFlappyImage() {
        if (Greenfoot.isKeyDown("space")) {
            setImage("images/flappybird3.png");
        } else if (velocity > 0) {
            setImage("images/flappybird1.png");
        } else {
            setImage("images/flappybird2.png");
        }
    }
}

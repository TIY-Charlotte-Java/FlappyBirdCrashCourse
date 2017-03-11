import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tube extends Actor
{
    /**
     * Act - do whatever the TopTube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX() - 10, getY());
        
        if (getX() < 0) {
            
            if (this instanceof TopTube) {
                ((MyWorld)getWorld()).increaseScore();
            }

            getWorld().removeObject(this);
        }
    }
}

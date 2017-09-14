import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @Jonathan Theron
 * @version 2017-09-10
 */
public class Scroller extends Actor
{
    private int startingY = -4215;

    /**
     * Act - do whatever the Scroller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    /**
     * scroll - Sets the starting location of the background image
     */
    public void scroll()
    {
        if(getY() > getImage().getHeight())
            setLocation(getX(), startingY);

        setLocation(getX(), getY()+ MyWorld.speed);
    }
}


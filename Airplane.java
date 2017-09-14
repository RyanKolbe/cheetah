import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @Jonathan Theron
 * @version 2017-09-10
 */
public class Airplane extends Actor
{
    public Airplane()
    {

    }

    public int health = 100;

    /**
     * Act - do whatever the Airplane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public void fireMachinegun(int inRotation)
    {
        Projectile bullet = new Projectile(inRotation);
        getWorld().addObject(bullet, getX(), getY());
    }
    
    
}

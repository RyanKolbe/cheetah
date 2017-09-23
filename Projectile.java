import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @Jonathan Theron
 * @version 2017-09-10
 */
public class Projectile extends Actor
{
    public static int damage = 5; //projectile damage
    public static int speed = 15; //projectile speed
    
    /**
     * Projectile constructer
     * Para: #inRotation
     **/
    public Projectile()
    {       
        setRotation(90);
        GreenfootImage img = getImage();
        img.scale(20,20);
        move(5);
        Greenfoot.playSound("gunShot.wav");
    }

    public Projectile(int inRotation)
    {       
        setRotation(inRotation);
        GreenfootImage img = getImage();
        img.scale(15,15);
        move(5);
        Greenfoot.playSound("gunShot.wav");
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(speed);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }  
}

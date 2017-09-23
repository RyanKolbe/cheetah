import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Actor
{
    //projectile damage
    public static int damage = 5;
    
    //projectile speed
    public static int speed = 15;
    
    /**
     * Enemy projectile constructor
     * Para: #inRotation
     */
    public EnemyProjectile()
    {
        setRotation(-90);
        GreenfootImage img = getImage();
        img.scale(15, 15);
        move(5);
        Greenfoot.playSound("gunShot.wav");
    }
        public EnemyProjectile(int inRotation)
    {
        setRotation(inRotation);
        GreenfootImage img = getImage();
        img.scale(15, 15);
        move(5);
        Greenfoot.playSound("gunShot.wav");
    }
    /**
     * Act - do whatever the EnemyProjectile wants to do. This method is called whenever
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

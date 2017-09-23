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

    private double preciseX;
    private double preciseY;
    public int health = 100;

    /**
     * Move forward by specified distance and overrides the method in Actor.
     */
    @Override
    public void move(int distance)
    {
        move((double)distance);
    }

    /**
     * Moved forward by the specified precise distance.
     */
    public void move(double distance)
    {
        double radians = Math.toRadians(getRotation());
        double dx = Math.cos(radians) * distance;
        double dy = Math.sin(radians) * distance;
        setLocation(preciseX + dx, preciseY + dy);
    }

    /**
     * Set the location using precise coordinates.
     */
    public void setLocation(double x, double y)
    {
        preciseX = x;
        preciseY = y;
        super.setLocation((int) (x + 0.5), (int) (y + 0.5));
    }

    /**
     * Returns the precise x-coordinate as a double.
     */
    public double getPreciseX()
    {
        return preciseX;
    }

    /**
     * Returns the precise y-coordinate as a double.
     */

    public double getPreciseY()
    {
        return preciseY;
    }

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

    public void enemyMachineGun(int inRotation)
    {
        EnemyProjectile bullet = new EnemyProjectile(inRotation);
        getWorld().addObject(bullet, getX(), getY());
    }
}

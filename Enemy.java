import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Airplane
{
    /**
     * Enemy image array.
     */
    private String [] img = new String[3];

    /**
     *  Animation variables.
     */
    private int aCounter = 0;
    /**
     * Sets scale of image.
     */
    private static int imgX = 115;
    private static int imgY = imgX;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy()
    {
        for(int x = 0; x < img.length; x++)
        {
            img[x] = "e" + x + ".png";
        }
        setImage(img[0]);
        setRotation(180);
        getImage().scale(imgX,imgY);
    }

    public void act() 
    {
        // Add your action code here.
        animationCounter();
        animatePropeller();
        enemyMovement();
        enemyWeapon();
        destroyEnemies();
    }

    /**
     * animationCounter - used to control the animations.
     */
    private void animationCounter()
    {
        aCounter++;
        if(aCounter == img.length)
            aCounter = 0;
    }

    /**
     * Fires machine gun.
     */
    private void enemyWeapon()
    {
        if(Greenfoot.getRandomNumber(100)>95)
        {
            enemyMachineGun(90);
        }
    }

    /**
     * Flight class of enemy planes.
     */
    public void enemyMovement()
    {
        setLocation(getX(), getY()+5);
        if(isAtEdge())
        {
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()),0);
        }
    }

    /**
     * Controls the animation of the plane's propeller.
     */
    private void animatePropeller()
    {
        for(int z= 0; z < img.length; z++)
        {
            if(aCounter == z)
                setImage(img[z]);
            getImage().scale(imgX, imgY);
        }
    }

    public void destroyEnemies()
    {
        Actor Projectile = getOneIntersectingObject(Projectile.class);
        if (Projectile != null)
        {
            removeTouching(Projectile.class);
            setLocation( 50 + Greenfoot.getRandomNumber(400),10);
        }
    }
}

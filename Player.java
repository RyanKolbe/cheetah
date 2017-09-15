import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @Jonathan Theron
 * @version 2017-09-11
 */
public class Player extends Airplane
{    

    //Plane image array
    private String [] img = new String[3];
    
    //Animation variables
    private int delay = 4;
    private int aCounter = 0;//animationCounter
    
    //Scale of image
    private static int imgX = 140;
    private static int imgY = imgX;

    //Control variables
    private boolean isDown = false;
    private int counter = 0;
    
    //Create object of type GreenfootSound called engineSound.
    GreenfootSound engineSound = new GreenfootSound("engine1.wav");

    public Player()
    {
        for(int x = 0; x < img.length; x++)
        {
            img[x] = x + ".png";
        }
        setImage(img[0]);
        getImage().scale(imgX,imgY);
    }

    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        counter++;

        //Plays engine sounds
        playSound();

        // movement of plane
        border();
        movePlane();

        //fireWeapons
        fireWeapon();

        animationCounter(); 
        animatePropeller();
    }   

    private void fireWeapon()
    {
        if(Greenfoot.isKeyDown("space") && !isDown)
           { 
               fireMachinegun(-90); //Fires machinegun at -90deg.
               isDown = true;
           }
        else if(!Greenfoot.isKeyDown("space") && isDown)
        {
            isDown = false;
        }
    }

    public void playSound()
    {        
        if(!engineSound.isPlaying())
            engineSound.playLoop();
        engineSound.setVolume(40);
    }

    private void movePlane()
    {
        if(Greenfoot.isKeyDown("left"))
            setLocation(getX()-MyWorld.speed,getY());

        if(Greenfoot.isKeyDown("right"))
            setLocation(getX()+MyWorld.speed,getY());

        if(Greenfoot.isKeyDown("up"))
            setLocation(getX(),getY()-MyWorld.speed);

        if(Greenfoot.isKeyDown("down"))
            setLocation(getX(),getY()+MyWorld.speed/2);    
    }

    /**
     * takingDamage used to track damage to plane.
     *        
     */
    private void takingDamage(int damageAmount)
    {    
        if(health <= 0)
        {
            getWorld().showText("Game Over!",getWorld().getWidth()/2,getWorld().getHeight()/2);
            getWorld().removeObject(this);            
            Greenfoot.stop();
        }
        else
        {
            if(isTouching(Enemy.class))
                this.health -= damageAmount;  
        }               
    }

    /**
     *  
     *  border - used to keep the plane on the screen
     */
    private void border()
    {
        //check right border
        if(getX() >= getWorld().getWidth()-10)
            setLocation(getX()-MyWorld.speed,getY());

        //check left border
        if(getX() <= 10) 
            setLocation(getX()+MyWorld.speed,getY());

        //check bottom border
        if(getY() >= getWorld().getHeight()-10)
            setLocation(getX(),getY()-MyWorld.speed);

        //check top border
        if(getY() <= 10)
            setLocation(getX(),getY()+MyWorld.speed);
    }

    /**
     * animaitonCounter - used to control the animations.
     */
    private void animationCounter()
    {
        aCounter++;
        if(aCounter == img.length) //Resets the counter to 0;
            aCounter = 0;
    }

    /**
     * animatePropeller - controls the animation of the plane's propeller.
     */
    private void animatePropeller()
    {
        //sets the image to the animation   
        for(int z = 0; z < img.length; z++)
        {
            if(aCounter == z)
                setImage(img[z]);

            getImage().scale(imgX,imgY);
        }
    }
}

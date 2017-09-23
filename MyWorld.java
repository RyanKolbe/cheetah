import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @Jonathan Theron
 * @v1.2
 * @2017-09-11
 */
public class MyWorld extends World
{
    //
    private Background img0, img1;
    private int counter;
    public static int speed = 5;    //Speed of map scroll and aiplanes 
    public int enemyCounter = 0;
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x255 cells with a cell size of 1x1 pixels.
        super(528, 800, 1, false); 
        prepare();
        counter = 0;
        setPaintOrder(Airplane.class, Enemy.class,Projectile.class); 
        display();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Creates instance of background at set location
        img0 = new Background();
        addObject(img0, getWidth()/2, - 1300);

        img1 = new Background();
        addObject(img1, getWidth()/2, - 5519);

        //adds player1 in bottom middle of map.
        addObject(new Player(), getWidth()/2, getHeight()-50);

        for( int i = 0; i < 4; i++)
        {
            addObject(new Enemy(), 50 + Greenfoot.getRandomNumber(400),
                50 + Greenfoot.getRandomNumber(100));     
        }
    }

    public void display()
    {
        showText("Health = " + "Full", getWidth()-100, getHeight()-20);
        showText("Fuel = " + "Full", getWidth()-468, getHeight()-20);
    }

    public void act()
    {
        //Scrolls map
        img0.scroll();
        img1.scroll();     
        counter++;
    }

}
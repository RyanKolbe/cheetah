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

    //Speed of map scroll and aiplanes 
    public static int speed = 5;


    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x255 cells with a cell size of 1x1 pixels.
        super(528, 800, 1, false); 
        prepare();
        counter = 0;
        setPaintOrder(Airplane.class, Projectile.class);
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

        //adds player1 in bottom middel of map.
        addObject(new player1(), getWidth()/2, getHeight()-50);

        Enemy enemy = new Enemy();
        addObject(enemy,Greenfoot.getRandomNumber(getWidth()),getHeight());
        Enemy enemy2 = new Enemy();
        addObject(enemy2,247,208);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,379,143);
        enemy.setLocation(105,800);
        enemy.setLocation(112,34);
        enemy.setLocation(92,91);
        enemy3.setLocation(453,88);
        enemy.setLocation(65,83);
        enemy2.setLocation(270,201);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,160,232);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,421,237);
        enemy.setLocation(62,67);
        enemy4.setLocation(152,148);
        enemy3.setLocation(468,60);
        enemy5.setLocation(400,161);
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

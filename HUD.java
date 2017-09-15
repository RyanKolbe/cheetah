import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   
    int life=5, barWidth=100, barHeight=20, hitDamage=(int)barWidth/life;
    
    public void act() 
    {
        display();

    }    
    
    public HUD()
    {
    
        display();
    }
    

    
        public void display()
    {
        setImage(new GreenfootImage(barWidth+1, barHeight+1));
        GreenfootImage img = getImage();
        img.setColor(Color.BLACK);
        img.drawRect(-20,-100,barWidth, barHeight);
        img.setColor(Color.BLUE);
        img.fillRect(1,1,life*hitDamage, barHeight);
    }
    
    public void damage()
    {
        life--;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act()
    {
        setLocation(getX() + 1 , getY());
        MyWorld world = (MyWorld) getWorld();
        if(getX() == world.getWidth()-1){
            world.gameOver();
            world.removeObject(this);
            
        }
    }
    
    public void setSpeed(int s){
        speed = s;
    }
}

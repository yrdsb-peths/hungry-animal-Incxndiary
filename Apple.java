import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Fries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act()
    {
        setLocation(getX(), getY() + speed);
        MyWorld world = (MyWorld) getWorld();
        if(getY() == world.getHeight()-1){
            world.gameOver();
            world.removeObject(this);
            
        }
    }
    
    public void setSpeed(int s){
        speed = s;
    }
}

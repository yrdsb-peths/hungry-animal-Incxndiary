import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Actor
{
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage fastImage = new GreenfootImage("images/SPWRUP.png");
    
    SimpleTimer spawn = new SimpleTimer();

    int speed = 1;
    int level = 1;
    public Powerup(){
        fastImage.scale(10, 10);
    }
    public void act()
    {
        setLocation(getX(), getY() + speed);
        MyWorld world = (MyWorld) getWorld();
        
        if(getY() == world.getHeight()-1){
            world.removeObject(this);
            world.createPowerup();
        }
    }
    
    
    public void setSpeed(int s){
        speed = s;
    }
}

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
    
    GreenfootImage[] sidle = new GreenfootImage[4];
    SimpleTimer animateTimer = new SimpleTimer();
    
    public Enemy(){
        for(int i = 0; i < sidle.length; i++){
            sidle[i] = new GreenfootImage("images/shark_idle/sidle" + i + ".png");
            sidle[i].mirrorHorizontally();
        }
        animateTimer.mark();
        
        setImage(sidle[0]);
    }
    
    int imageIndex = 0;
    
    public void animateShark(){
        if(animateTimer.millisElapsed() < 500){
            return;
        }
        animateTimer.mark();
        
        setImage(sidle[imageIndex]);
        imageIndex = (imageIndex + 1) % sidle.length;
    }
    
    int speed = 1;
    
    public void act()
    {
        setLocation(getX() + 1 , getY());
        MyWorld world = (MyWorld) getWorld();
        if(getX() == world.getWidth()-1){
            world.removeObject(this);
            
        }
        animateShark();
    }
    
    public void setSpeed(int s){
        speed = s;
    }
}

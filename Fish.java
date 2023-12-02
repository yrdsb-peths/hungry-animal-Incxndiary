import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound FishSound = new GreenfootSound("fisheat.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[10];
    GreenfootImage[] idleLeft = new GreenfootImage[10];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    
    public Fish(){
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/fish_idle/idle" + i + ".png");
            idleRight[i].scale(50, 50);
        }
        
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/fish_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateFish(){
        if(animationTimer.millisElapsed() < 500){
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 2);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 2);
        }
        if(Greenfoot.isKeyDown("left")){
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right")){
            move(2);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 2);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + 2);
        }
        
        eat();
        powerUp();
        animateFish();
    }
    public void eat(){
        if(isTouching(Fries.class)){
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFries();
            world.increaseScore();
            FishSound.play();
        }
        
    }
    public void powerUp(){
        if(isTouching(Powerup.class)){
            removeTouching(Powerup.class);
            
            
            MyWorld world = (MyWorld) getWorld();
            world.createPowerup();
            
        }
    }
}

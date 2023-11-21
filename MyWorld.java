import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Fish fish = new Fish();
        addObject(fish, 300, 300);
        
        createFries();
    }
    public void createFries(){
        Fries fries = new Fries();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fries, x, y);
    }
    
}

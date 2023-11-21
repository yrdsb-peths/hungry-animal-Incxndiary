import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
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
        scoreLabel = new Label(0, 40);
        addObject(scoreLabel, 20, 20);
        createFries();
    }

    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, 300, 300);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    public void createFries(){
        Fries fries = new Fries();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fries, x, y);
        
    }

}

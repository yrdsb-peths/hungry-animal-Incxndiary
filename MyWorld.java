import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true);
        Fish fish = new Fish();
        addObject(fish, 300, 300);
        scoreLabel = new Label(0, 40);
        addObject(scoreLabel, 20, 20);
        createFries();
        createPowerup();
    }

    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, 300, 300);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        if(score%10 == 0){
            level += 1;
        }
    }
    public void createFries(){
        Fries fries = new Fries();
        fries.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fries, x, y);
        
    }

    public void createPowerup(){
        Powerup Power = new Powerup();
        Power.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(Power, x, y);
    }
}

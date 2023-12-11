import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    SimpleTimer spawn = new SimpleTimer();
    
    /* 
     * I like how you changed the elephant actor to a fish and you added 
     * a shark as an enemy. I like the calm noise it makes when 
     * you die to the shark :)))
     */
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
        createApple();
        createEnemy();
        createPowerup();
        
    }
    
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, 300, 300);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        if(score % 10 == 0){
            level += 1;
        }
    }
    public void createApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        
    }

    public void createPowerup(){
        spawn.mark();
        Powerup Power = new Powerup();
        Power.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(Power, x, y);
    }
    
    public void createEnemy(){
        Enemy shark = new Enemy();
        shark.setSpeed(level);
        int x = 0;
        int y = Greenfoot.getRandomNumber(600);
        addObject(shark, x, y);
        
    }
    
}

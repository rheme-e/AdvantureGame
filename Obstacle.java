package AdvantureGame;

public abstract class Obstacle {
    private String obstackleName;
    private int obstackleNumber;
    private int damage;
    private int health;
    private int money;

    public Obstacle(String obstackleName, int obstackleNumber, int damage, int health,int money) {
        this.obstackleName = obstackleName;
        this.obstackleNumber = obstackleNumber;
        this.damage = damage;
        this.health = health;
        this.money= money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getObstackleNumber() {
        return obstackleNumber;
    }

    public void setObstackleNumber(int obstackleNumber) {
        this.obstackleNumber = obstackleNumber;
    }

    public String getObstackleName() {
        return obstackleName;
    }

    public void setObstackleName(String obstackleName) {
        this.obstackleName = obstackleName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

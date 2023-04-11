package AdvantureGame;

public abstract class GameChar{

    private String name;
    private int block;
    private int damage;
    private int healt;
    private int money;

    public GameChar(String name, int block, int damage, int healt, int money) {
        this.name = name;
        this.block = block;
        this.damage = damage;
        this.healt = healt;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

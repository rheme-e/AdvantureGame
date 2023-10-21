package AdvantureGame;

public class Guns {
    private String name;
    private int Id;
    private int damage;
    private int money;

    public Guns(String name, int id, int damage, int money) {
        this.name = name;
        Id = id;
        this.damage = damage;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

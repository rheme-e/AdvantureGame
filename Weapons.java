package AdvantureGame;

import java.util.Scanner;

public abstract class Weapons {
    Scanner inp = new Scanner(System.in);
    private String name;
    private int damage;
    private int money;

    public Weapons(String name, int damage, int money) {
        this.name = name;
        this.damage = damage;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

package AdvantureGame;

import java.util.Scanner;

public class Player {
    Scanner inp = new Scanner(System.in);
    private String name;
    private String playerName;
    private int damage;
    private int healt;
    private int money;
    private int block;
    private int counterWater=0;
    private int counterFirewood=0;
    private int counterFood=0;
    private int counterGun=0;
    private int counterSword=0;
    private int counterRifle=0;


    public Player(String playerName) {
        this.playerName = playerName;

    }
    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler:");
        for (int i = 1; i < 2; i++) {
            for (GameChar gameChar : charList) {
                System.out.println(i + ":  " + gameChar.getName() + "\tVerdiği hasar:" + gameChar.getDamage() +
                        "\tSağlığı:" + gameChar.getHealt() + "\tPara:" + gameChar.getMoney());
                i++;
            }
        }
        System.out.println("Bir Karakter Seçiniz:");
        while (true) {
            int id = inp.nextInt();
            if (id == 1) {
                initPlayer(new Samurai());
                break;
            } else if (id == 2) {
                initPlayer(new Archer());
                break;
            } else if (id == 3) {
                initPlayer(new Knight());
                break;
            } else {
                System.out.println("Geçersiz giriş yaptınız,lütfen tekrar deneyiniz.");
            }

        }
        System.out.println("Seçtiğiniz Karakter:" + this.getName() + "\tHasar:" + this.getDamage() +
                "\tSağlık:" + this.getHealt() + "\tPara:" + this.getMoney() );

    }

    public void initPlayer(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealt(gameChar.getHealt());
        this.setMoney(gameChar.getMoney());
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }


    public int getCounterWater() {
        return counterWater;
    }

    public void setCounterWater(int counterWater) {
        this.counterWater = counterWater;
    }

    public int getCounterFirewood() {
        return counterFirewood;
    }

    public void setCounterFirewood(int counterFirewood) {
        this.counterFirewood = counterFirewood;
    }

    public int getCounterFood() {
        return counterFood;
    }

    public void setCounterFood(int counterFood) {
        this.counterFood = counterFood;
    }

    public int getCounterGun() {
        return counterGun;
    }

    public void setCounterGun(int counterGun) {
        this.counterGun = counterGun;
    }

    public int getCounterSword() {
        return counterSword;
    }

    public void setCounterSword(int counterSword) {
        this.counterSword = counterSword;
    }

    public int getCounterRifle() {
        return counterRifle;
    }

    public void setCounterRifle(int counterRifle) {
        this.counterRifle = counterRifle;
    }
}

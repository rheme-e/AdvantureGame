package AdvantureGame;

import java.util.Scanner;

public class Armors {
    Scanner inp = new Scanner(System.in);
    private String name;
    private int block;
    private int money;




    public Armors(String name, int block, int money) {
        this.name = name;
        this.block = block;
        this.money = money;
    }

    public static Armors[] armors(){
        Armors[] armorsList= new Armors[3];
        armorsList[0]=new Armors("Hafif",1,15);
        armorsList[1]=new Armors("Orta",3,25);
        armorsList[2]=new Armors("Ağır",5,40);
        return armorsList;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

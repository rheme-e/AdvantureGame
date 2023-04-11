package AdvantureGame;

import java.util.Random;

public class Forest extends BattleLoc {

    Vampire vampire = new Vampire();

    public Forest(Player player) {


        super(player, "Orman", new Vampire());
    }

    public boolean startPlayer() {
        int vampireLife = vampire.getHealth() - getPlayer().getDamage();
        vampire.setHealth(vampireLife);
        System.out.println("Vampirler " + getPlayer().getDamage() + " hasar aldı.Vampirlerin kalan sağlığı:"
                + vampire.getHealth() + "\tSenin kalan sağlığın:" + getPlayer().getHealt());


        return false;
    }

    public boolean startVampire() {
        if (getPlayer().getBlock() > 0) {
            if (getPlayer().getBlock() > vampire.getDamage()) {
                int playerLife = getPlayer().getHealt();
                getPlayer().setHealt(playerLife);
            } else {
                int playerLife = getPlayer().getHealt() - vampire.getDamage() + getPlayer().getBlock();
                getPlayer().setHealt(playerLife);
            }
            System.out.println("Vampirleri " + getPlayer().getBlock() + " hasar kadar blokladın!");
            getPlayer().setBlock(0);
            System.out.println(vampire.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Vampirlerin kalan sağlığı:" + vampire.getHealth());
        }else {
            int playerLife = getPlayer().getHealt() - vampire.getDamage();
            getPlayer().setHealt(playerLife);
            System.out.println(vampire.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Vampirlerin kalan sağlığı:" + vampire.getHealth());
        }

        return false;
    }

    public boolean dead() {
        if (vampire.getHealth() <= 0) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("SAVAŞI KAZANDINIZ!");
            System.out.println("Kalan canınız:" + getPlayer().getHealt());
            getPlayer().setMoney(vampire.getMoney() + getPlayer().getMoney());
            System.out.println("Paranız:" + getPlayer().getMoney());
            if (this.getPlayer().getCounterFirewood() == 0) {
                System.out.println("Tebrikler 'Odunu' aldınız!!!");
                getPlayer().setCounterFirewood(1);
                return false;
            }
        } else if (getPlayer().getHealt() <= 0) {
            System.out.println("------------------------------------------------------------------------------" +
                    "\n\t\t\t\t\t\t\t\t\t!!!GAME OVER!!!");
            return false;
        }
        return false;
    }

    @Override
    public boolean onLocation() {

        System.out.println("Ormandasınız:\nDikkat Vampirler!!! SAVAŞ BAŞLASIN !!!");
        Random rand = new Random();
        int randomvampire = rand.nextInt(1, 4);
        int randomStart = rand.nextInt(1, 3);
        System.out.println(randomvampire + " Vampire karşı savaşıyorsun!");
        if(randomStart==1){
            System.out.println("Şanslısın ilk hamleyi sen yapıyorsun!");
        }else{
            System.out.println("İlk saldıran vampirler oldu!");
        }

        int tempvampireLife = vampire.getHealth() * randomvampire;
        vampire.setHealth(tempvampireLife);
        while (true) {
            if (randomStart == 1) {
                while (true) {
                    if (getPlayer().getHealt() > 0 && vampire.getHealth() > 0) {
                        int i=1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startPlayer();
                        startVampire();
                    } else {
                        dead();
                        return false;
                    }
                }
            } else {
                while (true) {
                    if (getPlayer().getHealt() > 0 && vampire.getHealth() > 0) {
                        int i=1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startVampire();
                        startPlayer();
                    } else {
                        dead();
                        return false;
                    }
                }
            }

        }
    }
}


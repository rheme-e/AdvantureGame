package AdvantureGame;

import java.util.Arrays;
import java.util.Random;

public class River extends BattleLoc {
    Random random = new Random();
    Bear bear = new Bear();

    public River(Player player) {

        super(player, "Nehir", new Bear());
    }




    public boolean startPlayer() {
        int bearLife = bear.getHealth() - getPlayer().getDamage();
        bear.setHealth(bearLife);
        System.out.println("Ayılar " + getPlayer().getDamage() + " hasar aldı.Ayıların kalan sağlığı:"
                + bear.getHealth() + "\tSenin kalan sağlığın:" + getPlayer().getHealt());


        return false;
    }

    public boolean startBear() {
        if (getPlayer().getBlock() > 0) {
            if (getPlayer().getBlock() > bear.getDamage()) {
                int playerLife = getPlayer().getHealt();
                getPlayer().setHealt(playerLife);
            } else {
                int playerLife = getPlayer().getHealt() - bear.getDamage() + getPlayer().getBlock();
                getPlayer().setHealt(playerLife);
            }
            System.out.println("Ayıları " + getPlayer().getBlock() + " hasar kadar blokladın!");
            getPlayer().setBlock(0);
            System.out.println(bear.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Ayıların kalan sağlığı:" + bear.getHealth());
        } else {
            int playerLife = getPlayer().getHealt() - bear.getDamage();
            getPlayer().setHealt(playerLife);
            System.out.println(bear.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Ayıların kalan sağlığı:" + bear.getHealth());
        }

        return false;
    }

    public boolean dead() {
        if (bear.getHealth() <= 0) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("SAVAŞI KAZANDINIZ!");
            System.out.println("Kalan canınız:" + getPlayer().getHealt());
            getPlayer().setMoney(bear.getMoney() + getPlayer().getMoney());
            System.out.println("Paranız:" + getPlayer().getMoney());
            if (this.getPlayer().getCounterWater() == 0) {
                System.out.println("Tebrikler 'Suyu' aldınız!!!");
                getPlayer().setCounterWater(1);
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

        System.out.println("Nehirdesiniz:\nDikkat Ayılar!!! SAVAŞ BAŞLASIN !!!");
        Random rand = new Random();
        int randombear = rand.nextInt(1, 4);
        int randomStart = rand.nextInt(1, 3);
        System.out.println(randombear + " Ayıya karşı savaşıyorsun!");
        if (randomStart == 1) {
            System.out.println("Şanslısın ilk hamleyi sen yapıyorsun!");
        } else {
            System.out.println("İlk saldıran ayılar oldu!");
        }
        int tempbearLife = bear.getHealth() * randombear;
        bear.setHealth(tempbearLife);
        while (true) {
            if (randomStart == 1) {
                while (true) {
                    if (getPlayer().getHealt() > 0 && bear.getHealth() > 0) {
                        int i = 1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startPlayer();
                        startBear();
                    } else {
                        dead();
                        return false;
                    }
                }
            } else {
                while (true) {
                    if (getPlayer().getHealt() > 0 && bear.getHealth() > 0) {
                        int i = 1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startBear();
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

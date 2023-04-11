package AdvantureGame;

import java.util.Random;

public class Cave extends BattleLoc {
    Zombie zombie = new Zombie();


    public Cave(Player player) {
        super(player, "Mağara", new Zombie());
    }

    public boolean startPlayer() {
        int zombieLife = zombie.getHealth() - getPlayer().getDamage();
        zombie.setHealth(zombieLife);
        System.out.println("Zombiler " + getPlayer().getDamage() + " hasar aldı.Zombilerin kalan sağlığı:"
                + zombie.getHealth() + "\tSenin kalan sağlığın:" + getPlayer().getHealt());


        return false;
    }
    public boolean startBear(){
        if (getPlayer().getBlock() > 0) {
            if (getPlayer().getBlock() > zombie.getDamage()) {
                int playerLife = getPlayer().getHealt();
                getPlayer().setHealt(playerLife);
            } else {
                int playerLife = getPlayer().getHealt() - zombie.getDamage() + getPlayer().getBlock();
                getPlayer().setHealt(playerLife);
            }
            System.out.println("Zombileri " + getPlayer().getBlock() + " hasar kadar blokladın!");
            getPlayer().setBlock(0);
            System.out.println(zombie.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Zombilerin kalan sağlığı:" + zombie.getHealth());
        }else {
            int playerLife = getPlayer().getHealt() - zombie.getDamage();
            getPlayer().setHealt(playerLife);
            System.out.println(zombie.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Zombilerin kalan sağlığı:" + zombie.getHealth());
        }

        return false;
    }

    public boolean dead() {
        if (zombie.getHealth() <= 0) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("SAVAŞI KAZANDINIZ!");
            System.out.println("Kalan canınız:" + getPlayer().getHealt());
            getPlayer().setMoney(zombie.getMoney() + getPlayer().getMoney());
            System.out.println("Paranız:" + getPlayer().getMoney());
            if (this.getPlayer().getCounterFood() == 0) {
                System.out.println("Tebrikler 'Yemeği' aldınız!!!");
                getPlayer().setCounterFood(1);
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
        System.out.println("Mağaradasınız:\nDikkat Zombiler!!! SAVAŞ BAŞLASIN !!!");
        Random rand = new Random();
        int randomzombie = rand.nextInt(1, 4);
        int randomStart = rand.nextInt(1, 3);
        System.out.println(randomzombie + " Zombiye karşı savaşıyorsun!");
        if(randomStart==1){
            System.out.println("Şanslısın ilk hamleyi sen yapıyorsun!");
        }else{
            System.out.println("İlk saldıran zombiler oldu!");
        }
        int tempzombieLife = zombie.getHealth() * randomzombie;
        zombie.setHealth(tempzombieLife);
        while (true) {
            if (randomStart == 1) {
                while (true) {
                    if (getPlayer().getHealt() > 0 && zombie.getHealth() > 0) {
                        int i=1;
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
                    if (getPlayer().getHealt() > 0 && zombie.getHealth() > 0) {
                        int i=1;
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

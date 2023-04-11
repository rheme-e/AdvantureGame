package AdvantureGame;

import java.util.Random;

public class Coal extends BattleLoc {
    Snake snake = new Snake();
    Random random = new Random();

    public Coal(Player player) {
        super(player, "Maden", new Snake());
    }


    public int settDamage() {
        int randomDamage = random.nextInt(3, 7);
        snake.setDamage(randomDamage);
        return snake.getDamage();
    }

    public void setRandomLoot() {
        Weapons[] weaponList = {new Guns(), new Swords(), new Rifles()};
        Armors[] armorsList = Armors.armors();
        int randomLoot = random.nextInt(0, 100);
        if (randomLoot <= 15) {
            int randomGun = random.nextInt(0, 100);
            if (randomGun <= 20) {
                System.out.println("Tüfek kazandınız");
                getPlayer().setCounterRifle(1);
                getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage());
                System.out.println("Yeni Hasarınız:" + getPlayer().getDamage());
            } else if (randomGun > 20 && randomGun <= 50) {
                System.out.println("Kılıç kazandınız");
                getPlayer().setCounterSword(1);
                getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage());
                System.out.println("Yeni Hasarınız:" + getPlayer().getDamage());
            } else {
                System.out.println("Tabanca kazandınız");
                getPlayer().setCounterGun(1);
                getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage());
                System.out.println("Yeni Hasarınız:" + getPlayer().getDamage());
            }
        } else if (randomLoot > 15 && randomLoot <= 30) {
            int randomArmor = random.nextInt(0, 100);
            if (randomArmor <= 20) {
                System.out.println("Ağır Zırh kazandınız");
                getPlayer().setBlock(armorsList[2].getBlock());
                System.out.println("Yeni blok gücünüz:"+getPlayer().getBlock());
            } else if (randomArmor > 20 && randomArmor <= 50) {
                System.out.println("Orta Zırh kazandınız");
                getPlayer().setBlock(armorsList[1].getBlock());
                System.out.println("Yeni blok gücünüz:"+getPlayer().getBlock());
            } else {
                System.out.println("Hafif Zırh kazandınız");
                getPlayer().setBlock(armorsList[0].getBlock());
                System.out.println("Yeni blok gücünüz:"+getPlayer().getBlock());
            }

        } else if (randomLoot > 30 && randomLoot <= 55) {
            int randomMoney = random.nextInt(0, 100);
            if (randomMoney <= 20) {
                System.out.println("10 para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney()+10);
                System.out.println("Güncel bakiyeniz:"+getPlayer().getMoney());
            } else if (randomMoney > 20 && randomMoney <= 50) {
                System.out.println("5 para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney()+5);
                System.out.println("Güncel bakiyeniz:"+getPlayer().getMoney());
            } else {
                System.out.println("1 para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney()+1);
                System.out.println("Güncel bakiyeniz:"+getPlayer().getMoney());
            }
        } else {
            System.out.println("Hiç bir şey kazanamadınız");
        }

    }

    public boolean startPlayer() {
        int snakeLife = snake.getHealth() - getPlayer().getDamage();
        snake.setHealth(snakeLife);
        System.out.println("Yılanlar " + getPlayer().getDamage() + " hasar aldı.Yılanların kalan sağlığı:"
                + snake.getHealth() + "\tSenin kalan sağlığın:" + getPlayer().getHealt());

        return false;
    }

    public boolean startSnake() {
        if (getPlayer().getBlock() > 0) {
            if (getPlayer().getBlock() > snake.getDamage()) {
                int playerLife = getPlayer().getHealt();
                getPlayer().setHealt(playerLife);
            } else {
                int playerLife = getPlayer().getHealt() - snake.getDamage() + getPlayer().getBlock();
                getPlayer().setHealt(playerLife);
            }
            System.out.println("Yılanları " + getPlayer().getBlock() + " hasar kadar blokladın!");
            getPlayer().setBlock(0);
            System.out.println(snake.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Yılanların kalan sağlığı:" + snake.getHealth());
        } else {
            int playerLife = getPlayer().getHealt() - snake.getDamage();
            getPlayer().setHealt(playerLife);
            System.out.println(snake.getDamage() + " hasar aldın.Kalan sağlığın:"
                    + getPlayer().getHealt() + " Yılanların kalan sağlığı:" + snake.getHealth());
        }

        return false;
    }

    public boolean dead() {
        if (snake.getHealth() <= 0) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("SAVAŞI KAZANDINIZ!");
            System.out.println("Kalan canınız:" + getPlayer().getHealt());
            setRandomLoot();

        } else if (getPlayer().getHealt() <= 0) {
            System.out.println("------------------------------------------------------------------------------" +
                    "\n\t\t\t\t\t\t\t\t\t!!!GAME OVER!!!");
            return false;
        }
        return false;
    }

    @Override
    public boolean onLocation() {
        settDamage();
        System.out.println("Madendesiniz:\nDikkat Yılanlar!!! SAVAŞ BAŞLASIN !!!");
        Random rand = new Random();
        int randomsnake = rand.nextInt(1, 6);
        int randomStart = rand.nextInt(1, 3);
        System.out.println(randomsnake + " Yılana karşı savaşıyorsun!");
        if (randomStart == 1) {
            System.out.println("Şanslısın ilk hamleyi sen yapıyorsun!");
        } else {
            System.out.println("İlk saldıran yılanlar oldu!");
        }
        int tempsnakeLife = snake.getHealth() * randomsnake;
        snake.setHealth(tempsnakeLife);
        while (true) {
            if (randomStart == 1) {
                while (true) {
                    if (getPlayer().getHealt() > 0 && snake.getHealth() > 0) {
                        int i = 1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startPlayer();
                        startSnake();
                    } else {
                        dead();
                        return false;
                    }
                }
            } else {
                while (true) {
                    if (getPlayer().getHealt() > 0 && snake.getHealth() > 0) {
                        int i = 1;
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Round:" + i);
                        i++;
                        startSnake();
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

package AdvantureGame;

import java.util.Scanner;

public class Game {
    Scanner inp = new Scanner(System.in);

    public void start() {
        System.out.println("------------------------------------------------------------------------------\n\t\t\t\t\t\t\tMacera Oyununa Hoşgeldiniz!");
        Player player = new Player("esra");
        player.selectChar();
        int tempHealt=0;
        tempHealt=player.getHealt();
        while (player.getHealt()>0) {
            if(player.getCounterWater()!=1 || player.getCounterFirewood()!=1 || player.getCounterFood()!=1){
                Location[] locList = {new SafeHouse(player), new ToolStore(player), new Forest(player),
                        new River(player), new Cave(player), new Coal(player)};
                System.out.println("------------------------------------------------------------------------------\nMekan Seçiniz:");
                for (int i = 1; i < 2; i++) {
                    for (Location location : locList) {
                        System.out.println(i + ":\t" + location.getName());
                        i++;
                    }
                }
                System.out.println("------------------------------------------------------------------------------");
                int id = inp.nextInt();
                while (id <= 6){
                    if (id == 1) {
                        locList[id - 1] = new SafeHouse(player);
                        locList[id - 1].onLocation();
                        player.setHealt(tempHealt);
                        System.out.println("Canınız:"+player.getHealt());
                        break;
                    } else if (id == 2) {
                        locList[id - 1] = new ToolStore(player);
                        locList[id - 1].onLocation();
                        break;
                    } else if (id == 3) {
                        if(player.getCounterFirewood()==1){
                            System.out.println("Ödül kazanılan bölgeye tekrar giriş yapılamaz!");
                            break;
                        }
                        locList[id - 1] = new Forest(player);
                        locList[id - 1].onLocation();
                        break;
                    } else if (id == 4) {
                        if(player.getCounterWater()==1){
                            System.out.println("Ödül kazanılan bölgeye tekrar giriş yapılamaz!");
                            break;
                        }
                        locList[id - 1] = new River(player);
                        locList[id - 1].onLocation();
                        break;
                    } else if (id == 5) {
                        if(player.getCounterFood()==1){
                            System.out.println("Ödül kazanılan bölgeye tekrar giriş yapılamaz!");
                            break;
                        }
                        locList[id - 1] = new Cave(player);
                        locList[id - 1].onLocation();
                        break;
                    }else if (id == 6) {
                        locList[id - 1] = new Coal(player);
                        locList[id - 1].onLocation();
                        break;
                    }
                }if( id > 6){
                    System.out.println("Yanlış Giriş Yaptınız Tekrar Deneyiniz!");
                }


            }else{
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("'''''''''''''''''''''TEBRİKLER OYUNU BAŞARI İLE BİTİRDİNİZ''''''''''''''''''''");
                break;
            }


        }


    }

}

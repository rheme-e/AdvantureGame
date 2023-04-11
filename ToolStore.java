package AdvantureGame;

import javax.tools.Tool;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        int loop=0;
        while (loop == 0){
            System.out.println("Mağazaya Hoşgeldiniz!\nYapmak istediğiniz işlemi seçiniz:\n1:\tSilah satın almak\n2:\tZırh satın almak\n3\tÇıkış\n");
            int id = inp.nextInt();
            while (id <= 3) {
                if (id == 1) {
                    Weapons[] weaponList = {new Guns(), new Swords(), new Rifles()};
                    System.out.println("Güncel Bakiyeniz:" + getPlayer().getMoney() +
                            "\nAlmak istediğiniz silahı seçiniz:\n");
                    for (int i = 1; i < 2; i++) {
                        for (Weapons weapons : weaponList) {
                            System.out.println(i + ":" + weapons.getName() + ":" + "\tHasar:" + weapons.getDamage()
                                    + "\tPara:" + weapons.getMoney());
                            i++;
                        }
                    }
                    System.out.println("4:Çıkış");
                    int selectWeapon = inp.nextInt();
                    if (selectWeapon == 1) {
                        if (getPlayer().getCounterGun() == 0) {
                            if (getPlayer().getMoney() >= weaponList[0].getMoney()) {
                                int amount = getPlayer().getMoney() - weaponList[0].getMoney();
                                getPlayer().setMoney(amount);
                                if (getPlayer().getCounterSword() == 0 && getPlayer().getCounterRifle() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage());
                                    getPlayer().setCounterGun(1);
                                }
                                if (getPlayer().getCounterSword() == 1 && getPlayer().getCounterRifle() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage() - weaponList[1].getDamage());
                                    getPlayer().setCounterSword(2);
                                    getPlayer().setCounterGun(1);
                                }
                                if (getPlayer().getCounterSword() == 2 && getPlayer().getCounterRifle() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage() - weaponList[2].getDamage());
                                }
                                if (getPlayer().getCounterSword() == 0 && getPlayer().getCounterRifle() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage() - weaponList[2].getDamage());
                                    getPlayer().setCounterRifle(2);
                                    getPlayer().setCounterGun(1);
                                }
                                if (getPlayer().getCounterSword() == 1 && getPlayer().getCounterRifle() == 2) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[0].getDamage() - weaponList[1].getDamage());
                                }

                                System.out.println("Satın alma işlemi başarılı." +
                                        "Bir adet Tabancanız oldu!\nYeni Hasar:" + getPlayer().getDamage() +
                                        "\nKalan bakiyeniz:" + amount + "\n------------------------------------------------------------------------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır" +
                                        "\n------------------------------------------------------------------------------");
                                id = 4;
                            }
                        } else {
                            System.out.println("Yalnızca bir kez tabanca alabilirsiniz!\n");
                        }


                    } else if (selectWeapon == 2) {
                        if (getPlayer().getCounterSword() == 0) {
                            if (getPlayer().getMoney() >= weaponList[1].getMoney()) {
                                int amount = getPlayer().getMoney() - weaponList[1].getMoney();
                                getPlayer().setMoney(amount);
                                if (getPlayer().getCounterGun() == 0 && getPlayer().getCounterRifle() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage());
                                    getPlayer().setCounterSword(1);
                                }
                                if (getPlayer().getCounterGun() == 1 && getPlayer().getCounterRifle() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage() - weaponList[0].getDamage());
                                    getPlayer().setCounterGun(2);
                                    getPlayer().setCounterSword(1);
                                }
                                if (getPlayer().getCounterGun() == 2 && getPlayer().getCounterRifle() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage() - weaponList[2].getDamage());

                                }
                                if (getPlayer().getCounterGun() == 1 && getPlayer().getCounterRifle() == 2) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage() - weaponList[0].getDamage());

                                }
                                if (getPlayer().getCounterGun() == 0 && getPlayer().getCounterRifle() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[1].getDamage() - weaponList[2].getDamage());
                                    getPlayer().setCounterSword(1);
                                    getPlayer().setCounterRifle(2);
                                }

                                System.out.println("Satın alma işlemi başarılı." +
                                        "Bir adet Kılıcınız oldu!\nYeni Hasar:" + getPlayer().getDamage() + "\nKalan bakiyeniz:" + amount
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır"
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            }
                        } else {
                            System.out.println("Yalnızca bir kez kılıç alabilirsiniz!\n");
                        }


                    } else if (selectWeapon == 3) {
                        if (getPlayer().getCounterRifle() == 0) {
                            if (getPlayer().getMoney() >= weaponList[2].getMoney()) {
                                int amount = getPlayer().getMoney() - weaponList[2].getMoney();
                                getPlayer().setMoney(amount);
                                if (getPlayer().getCounterGun() == 0 && getPlayer().getCounterSword() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage());
                                    getPlayer().setCounterRifle(1);
                                }
                                if (getPlayer().getCounterGun() == 2 && getPlayer().getCounterSword() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage() - weaponList[1].getDamage());
                                }
                                if (getPlayer().getCounterGun() == 1 && getPlayer().getCounterSword() == 0) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage() - weaponList[0].getDamage());
                                    getPlayer().setCounterGun(2);
                                    getPlayer().setCounterRifle(1);
                                }
                                if (getPlayer().getCounterGun() == 1 && getPlayer().getCounterSword() == 2) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage() - weaponList[0].getDamage());
                                }
                                if (getPlayer().getCounterGun() == 0 && getPlayer().getCounterSword() == 1) {
                                    getPlayer().setDamage(getPlayer().getDamage() + weaponList[2].getDamage() - weaponList[1].getDamage());
                                    getPlayer().setCounterSword(2);
                                    getPlayer().setCounterRifle(1);
                                }

                                System.out.println("Satın alma işlemi başarılı." +
                                        "Bir adet Tüfeğiniz oldu!\nYeni Hasar:" + getPlayer().getDamage() + "\nKalan bakiyeniz:" + amount
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır"
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            }

                        } else {
                            System.out.println("Yalnızca bir kez tüfek alabilirsiniz!\n");
                        }

                    }else {
                        System.out.println("Çıkış yaptınız.\n------------------------------------------------------------------------------");
                        id = 4;
                        break;
                    }

                } else if (id == 2) {
                    System.out.println("Güncel Bakiyeniz:" + getPlayer().getMoney() +
                            "\nAlmak istediğiniz zırhı seçiniz:\n");
                    Armors[] armorsList = Armors.armors();
                    for (int i = 1; i < 2; i++) {
                        for (Armors armors : Armors.armors()) {
                            System.out.println(i + ":\tZırh Adı:" + armors.getName() + "\tEngelleme:" + armors.getBlock() +
                                    "\tPara:" + armors.getMoney());
                            i++;
                        }
                    }
                    System.out.println("4:Çıkış");
                    int selectArmor = inp.nextInt();
                    if(selectArmor>0 && selectArmor<4 && getPlayer().getBlock()==armorsList[selectArmor-1].getBlock()){
                        System.out.println("Aynı zırhı iki kez alamazsınız!\n");
                        id = 4;
                    }else{
                        if (selectArmor == 1) {
                            if (getPlayer().getMoney() >= armorsList[0].getMoney()) {
                                int amount = getPlayer().getMoney() - armorsList[0].getMoney();
                                getPlayer().setMoney(amount);
                                getPlayer().setBlock(armorsList[0].getBlock());
                                System.out.println("Satın alma işlemi başarılı." +
                                        "Hafif bir zırhınız oldu!\nYeni Engellemeniz:"+getPlayer().getBlock()+"\nKalan bakiyeniz:" + amount
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır"+
                                        "\n------------------------------------------------------------------------------");
                                id = 4;
                            }
                        } else if (selectArmor == 2) {
                            if (getPlayer().getMoney() >= armorsList[1].getMoney()) {
                                int amount = getPlayer().getMoney() - armorsList[1].getMoney();
                                getPlayer().setMoney(amount);
                                getPlayer().setBlock(armorsList[1].getBlock());
                                System.out.println("Satın alma işlemi başarılı." +
                                        "Orta bir zırhınız oldu!\nYeni Engellemeniz:"+getPlayer().getBlock()+"\nKalan bakiyeniz:" + amount
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır"
                                        + "\n------------------------------------------------------------------------------");
                                id = 4;
                            }
                        } else if (selectArmor == 3) {
                            if (getPlayer().getMoney() >= armorsList[2].getMoney()) {
                                int amount = getPlayer().getMoney() - armorsList[2].getMoney();
                                getPlayer().setMoney(amount);
                                getPlayer().setBlock(armorsList[2].getBlock());
                                System.out.println("Satın alma işlemi başarılı." +
                                        "Ağır bir zırhınız oldu!\nYeni Engellemeniz:"+getPlayer().getBlock()+"\nKalan bakiyeniz:" + amount + "\n-----------------");
                                id = 4;
                            } else {
                                System.out.println("Bu ürün için yeterli bakiyeniz bulunmamaktadır" +
                                        "\n------------------------------------------------------------------------------");
                                id = 4;
                            }
                        }else{
                            System.out.println("Çıkış yaptınız."+ "\n------------------------------------------------------------------------------");
                            id = 4;
                            break;
                        }
                    }


                } else if (id == 3) {
                    System.out.println("Çıkış Yaptınız!");
                    loop=1;
                    break;
                }
            }

        }
        return true;
    }

}


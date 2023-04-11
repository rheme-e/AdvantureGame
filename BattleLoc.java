package AdvantureGame;

public abstract class BattleLoc extends Location{
    Obstacle obstacle;




    public BattleLoc(Player player, String name, Obstacle obstacle) {
        super(player, name);
        this.obstacle = obstacle;
    }

    @Override
    public abstract boolean onLocation();
}

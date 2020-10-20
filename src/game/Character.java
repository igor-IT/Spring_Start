package game;

import lombok.Data;

import java.util.Random;

@Data
public abstract class Character {

    private int power;
    private int hp;

    public Character() {
        this.power = powerInit();
        this.hp = hpInit();
    }

    protected abstract int hpInit();
    protected abstract int powerInit();
    public boolean isAlive(){return hp > 0;}
    public abstract void kick(Character character);
    public static int randomGen(int min, int max){
        Random random = new Random();
        return random.ints(min,max).findAny().getAsInt();
    }

    protected  void kill(){
        hp = 0;
    }

    protected void downPower(int powers){
        power -= powers;
    }

    protected void downHP(int damage){
        hp -= damage;
    }
}

package game;

public class Knight extends Character {
    @Override
    protected int hpInit() {
        return randomGen(2,12);
    }
    @Override
    protected int powerInit() {
        return randomGen(2,12);
    }
    @Override
    public void kick(Character character) {
        int damage = randomGen(1,getPower());
        character.downHP(damage);
        System.out.println("Knight kicked "+character.getClass().getSimpleName()+" damage -- "+damage);
    }
}

package game;

public class King extends Character {
    @Override
    protected int hpInit() {
        return randomGen(5,15);
    }

    @Override
    protected int powerInit() {
        return randomGen(5,15);
    }

    @Override
    public void kick(Character character) {
        int damage = randomGen(1,getPower());
        character.downHP(damage);
        System.out.println("King kicked "+character.getClass().getSimpleName()+" damage -- "+damage);
    }


}

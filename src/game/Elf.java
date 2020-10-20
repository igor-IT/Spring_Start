package game;

public class Elf extends Character {
    @Override
    protected int hpInit() {
        return 10;
    }

    @Override
    protected int powerInit() {
        return 10;
    }

    @Override
    public void kick(Character character) {
        if (getPower() > character.getPower()){
            character.kill();
        } else {
            character.downPower(character.getPower());
        }

    }
}

package game;

public class Hobbit extends Character {
    @Override
    protected int hpInit() {
        return 3;
    }

    @Override
    protected int powerInit() {
        return 0;
    }

    @Override
    public void kick(Character character) {
        cry();
    }

    private void cry() {
        System.out.println("I'm hobbit and my damage is 0");
    }
}

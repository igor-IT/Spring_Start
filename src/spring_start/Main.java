package spring_start;

public class Main {
    public static void main(String[] args) {
       // ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
        Worker worker = ObjectFactory.getInstance().createObject(Worker.class);
        worker.drinkBeer();
        worker.work();
    }
}

package spring_start;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
       // ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
        WorkerImpl worker = ObjectFactory.getInstance().createObject(WorkerImpl.class);
        while (true) {
            worker.drinkBeer();
            worker.work();
            Thread.sleep(1000);
        }
    }
}

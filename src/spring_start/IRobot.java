package spring_start;

import lombok.SneakyThrows;

public class IRobot {
    @InjectByType
    private Speaker speaker ;
    @InjectByType
    private Cleaner cleaner ;
    @SneakyThrows
    public void cleanRoom(){
        speaker.speak("I started");
        cleaner.clean();
        Thread.sleep(800);
        speaker.speak("I finished");
    }
}

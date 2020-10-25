package spring_start;

import lombok.SneakyThrows;
@Benchmark
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 8)
    private int repeat;
    @Init
    public void init(){
        System.out.println("Repeat = "+repeat);
    }
    @SneakyThrows
    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            Thread.sleep(200);
            System.out.println("ЖУЖУЖУЖУЖУЖУЖ---БрбРБРБРББРБРБРББР");
        }
    }
}

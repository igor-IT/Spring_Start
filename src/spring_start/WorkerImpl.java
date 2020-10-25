package spring_start;

public class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }
    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Life is good");
    }
}

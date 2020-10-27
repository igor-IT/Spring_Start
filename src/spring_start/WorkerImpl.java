package spring_start;

public class WorkerImpl  {

    public void work() {
        System.out.println("Working");
    }
    @Benchmark
    public void drinkBeer() {
        System.out.println("Life is good");
    }
}

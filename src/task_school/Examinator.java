package task_school;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examinator {

    private List<GeneratorRandomExercise> exercises = List.of(new GeneratorRandomMinusExerciseImpl(), new GeneratorRandomPlusExerciseImpl(), new GeneratorRandomMultiplyExerciseImpl());
    private Random random = new Random();
    public List<Exercise> getEx(int amount){
        ArrayList<Exercise> list = new ArrayList<>(amount);
      return IntStream.range(0,amount).mapToObj(numb->{
            int i = random.ints(0,exercises.size()).findFirst().getAsInt();
            return exercises.get(i).generateEx();
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Examinator examinator = new Examinator();
        List<Exercise> ex = examinator.getEx(10);
        ex.forEach(System.out::println);
    }

}

package task_school;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenerateExercisesImpl implements GenExercise {
    private double min;
    private double max;
    @Override
    public Exercise generateExercise() {
        return  Exercise.builder().a(Exercise.getRandomNumber(min,max)).b(Exercise.getRandomNumber(min,max)).build();
    }
}

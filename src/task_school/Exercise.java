package task_school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private double a;
    private double b;
    private double answer;
    private OperationMath operations;
    public static double getRandomNumber(double min, double max){
        Random random = new Random();
        return random.ints((int)min,(int)max).findAny().getAsInt();
    }
    @Override
    public String toString() {
        return a+" "+operations +" "+b+ " = "+ answer;
    }
}

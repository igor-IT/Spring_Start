package task_school;

public class GeneratorRandomPlusExerciseImpl implements GeneratorRandomExercise {
    private GenerateExercisesImpl generateExercises = new GenerateExercisesImpl(1,99);
    @Override
    public Exercise generateEx() {
        Exercise exercise = generateExercises.generateExercise();
        exercise.setOperations(OperationMath.PLUS);
        exercise.setAnswer(OperationMath.PLUS.getBinaryOperator().applyAsDouble(exercise.getA(),exercise.getB()));
        return exercise;
    }
}

package task_school;

public class GeneratorRandomMinusExerciseImpl implements GeneratorRandomExercise {
    private GenerateExercisesImpl generateExercises = new GenerateExercisesImpl(1,99);
    @Override
    public Exercise generateEx() {
        Exercise exercise = generateExercises.generateExercise();
        exercise.setOperations(OperationMath.MINUS);
        exercise.setAnswer(OperationMath.MINUS.getBinaryOperator().applyAsDouble(exercise.getA(),exercise.getB()));
        return exercise;
    }
}

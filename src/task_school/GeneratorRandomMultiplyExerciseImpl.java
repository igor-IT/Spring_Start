package task_school;

public class GeneratorRandomMultiplyExerciseImpl implements GeneratorRandomExercise {
    private GenerateExercisesImpl generateExercises = new GenerateExercisesImpl(1,10);
    @Override
    public Exercise generateEx() {
        Exercise exercise = generateExercises.generateExercise();
        exercise.setOperations(OperationMath.MULTIPLY);
        exercise.setAnswer(OperationMath.MULTIPLY.getBinaryOperator().applyAsDouble(exercise.getA(),exercise.getB()));
        return exercise;
    }
}

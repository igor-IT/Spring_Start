package task_school;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.function.DoubleBinaryOperator;

@AllArgsConstructor
@Getter
public enum OperationMath {

    PLUS("+",() -> '+',(a,b) -> a+b),
    MINUS("-",() -> '-',(a,b) -> a-b),
    MULTIPLY("*",() -> '*',(a,b) -> a*b),
    DIVIDE("/",() -> '/',(a,b) -> a/b);

    private final String name;
    private final Operations operation;
    private final DoubleBinaryOperator binaryOperator;

    @Override
    public String toString() {
        return name;
    }
}

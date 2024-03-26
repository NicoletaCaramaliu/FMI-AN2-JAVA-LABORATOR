package lab3.task2.calculatorResult;


import lab3.task2.CalculationRequest;

public class IntegerCalculationResult extends CalculationResult {
    public IntegerCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() {
        CalculationRequest request = getRequest();
        Integer leftOperand = (Integer) request.leftOperand();
        Integer rightOperand = (Integer) request.rightOperand();

        return switch (request.operation()) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            default -> throw new IllegalArgumentException();
        };
    }
}
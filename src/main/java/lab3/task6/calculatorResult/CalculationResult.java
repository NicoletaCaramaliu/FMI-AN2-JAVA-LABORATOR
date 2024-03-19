package lab3.task6.calculatorResult;

import lab3.task6.CalculationRequest;

public abstract class CalculationResult {
    private final CalculationRequest request;

    public CalculationResult(CalculationRequest request) {
        this.request = request;
    }

    public CalculationRequest getRequest() {
        return request;
    }
    public abstract Object computeResult();
}
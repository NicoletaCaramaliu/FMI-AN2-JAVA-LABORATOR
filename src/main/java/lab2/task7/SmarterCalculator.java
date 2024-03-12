package lab2.task7;

import java.util.ArrayList;
import java.util.List;

class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;

    public String getRequestType(){
        if (leftOperand instanceof Boolean || rightOperand instanceof Boolean) {
            return "Boolean";
        }
        else if (leftOperand instanceof Double || rightOperand instanceof Double) {
            return "Double";
        }
        else  {
            return "Integer";
        }
    }

    public String toString(){
        if (leftOperand instanceof Double && rightOperand instanceof Integer)
            return leftOperand + " " + operation + " " + (double) (int) rightOperand;
        if (leftOperand instanceof Integer && rightOperand instanceof Double)
            return (double) (int) leftOperand + " " + operation + " " + rightOperand;
        return leftOperand + " " + operation + " " + rightOperand;
    }

    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }
}

class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args){
        List<CalculatorRequest> requests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            Object leftOperand = parseOperand(args[i]);
            String operation = args[i + 1];
            Object rightOperand = parseOperand(args[i + 2]);

            CalculatorRequest request = new CalculatorRequest(leftOperand, rightOperand, operation);
            requests.add(request);

        }

        return requests;
    }

    private static Object parseOperand(String operand) {
        if (operand.equalsIgnoreCase("true") || operand.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(operand);
        } else if (operand.contains(".")) {
            return Double.parseDouble(operand);
        } else {
            return Integer.parseInt(operand);
        }
    }
}

abstract class CalculatorResult {
    private CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }

    public abstract Object computeResult();
}

class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }
    @Override
    public Object computeResult() {
        int leftOperand = (int) getRequest().getLeftOperand();
        int rightOperand = (int) getRequest().getRightOperand();
        String operation = getRequest().getOperation();

        switch (operation) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            case "%":
                return leftOperand % rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }
    @Override
    public Object computeResult() {
        double leftOperand = getRequest().getLeftOperand() instanceof Integer ? (double) (int) getRequest().getLeftOperand() : (double) getRequest().getLeftOperand();
        double rightOperand = getRequest().getRightOperand() instanceof Integer ? (double) (int) getRequest().getRightOperand() : (double) getRequest().getRightOperand();
        String operation = getRequest().getOperation();

        switch (operation) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            case "%":
                return leftOperand % rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }
    @Override
    public Object computeResult() {
        boolean leftOperand = (boolean) getRequest().getLeftOperand();
        boolean rightOperand = (boolean) getRequest().getRightOperand();
        String operation = getRequest().getOperation();

        switch (operation) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorResult> results = new ArrayList<>();
        List<CalculatorRequest> requests = InputConverter.mapRequests(args);

        for (CalculatorRequest request : requests) {
            String requestType = request.getRequestType();
            CalculatorResult result;
            switch (requestType) {
                case "Boolean":
                    result = new BooleanCalculatorResult(request);
                    break;
                case "Double":
                    result = new DoubleCalculatorResult(request);
                    break;
                case "Integer":
                    result = new IntegerCalculatorResult(request);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid request type: " + requestType);
            }
            results.add(result);
        }

        return results;
    }
}

class Main {
    public static void main(String[] args) {
        String[] inputArray = {
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1"
        };

        // Apelăm funcția foo cu array-ul de string-uri ca argument
        foo(inputArray);
    }

    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}

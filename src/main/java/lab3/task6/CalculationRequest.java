package lab3.task6;

public record CalculationRequest(Object leftOperand, Object rightOperand, String operation) {

    public RequestType getRequestType() {
        // Switch patterns are reserved for Java 21+

        if (this.leftOperand instanceof Boolean) {
            return RequestType.Boolean;
        } else if (this.leftOperand instanceof Integer) {
            return this.rightOperand instanceof Integer ? RequestType.Integer : RequestType.Double;
        } else if (this.leftOperand instanceof Double) {
            return RequestType.Double;
        }

        return RequestType.Undefined;
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }

    public enum RequestType {
        Undefined,
        Integer,
        Double,
        Boolean
    }
}
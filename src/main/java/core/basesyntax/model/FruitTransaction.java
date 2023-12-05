package core.basesyntax.model;

import java.util.stream.Stream;

public class FruitTransaction {
    private static final String INCORRECT_QUANTITY_EXCEPTION_MESSAGE
            = "Quantity can't be less than zero.";
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException(INCORRECT_QUANTITY_EXCEPTION_MESSAGE);
        }
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation of(String code) {
            return Stream.of(values())
                    .filter(o -> o.getCode().equals(code))
                    .findFirst()
                    .orElse(null);
        }
    }
}

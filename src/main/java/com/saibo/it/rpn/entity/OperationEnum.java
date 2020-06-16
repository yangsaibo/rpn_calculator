package com.saibo.it.rpn.entity;

import com.saibo.it.rpn.exception.TechnicalException;
import com.saibo.it.rpn.operations.*;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OperationEnum {
    ADD("+", new Addition()),
    SUBTRACT("-", new Subtraction()),
    MULTIPLY("*", new Multiplication()),
    DIVIDE("/", new Division()),
    CLEAR("clear", new Clearance()),
    UNDO("undo", new Undo()),
    SQRT("sqrt",new Square());

    private String operationName;
    private IOperate operation;

    OperationEnum(String operationName, IOperate operation){
        this.operationName = operationName;
        this.operation = operation;
    }

    public static IOperate getOperation(String operationName) throws TechnicalException {
        return Arrays.stream(OperationEnum.values())
                .filter(operationEnum -> operationEnum.operationName.equals(operationName))
                .map(OperationEnum::getOperation)
                .findFirst()
                .orElseThrow(()->new TechnicalException("5001", "Unsupported operation"));
    }
}

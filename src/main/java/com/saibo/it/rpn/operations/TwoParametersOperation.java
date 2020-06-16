package com.saibo.it.rpn.operations;


import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;
import com.saibo.it.rpn.exception.TechnicalException;

import java.math.BigDecimal;
import java.util.Stack;

public abstract class TwoParametersOperation {
    private static int TWO = 2;

    OperationRecord getOperationRecord(BigDecimal var1, BigDecimal var2, IOperate operation){
        Stack<BigDecimal> digitalStack = new Stack<>();
        digitalStack.push(var2);
        digitalStack.push(var1);
        return new OperationRecord(digitalStack, operation);
    }

    protected boolean isValidOperation(OperationHistory history, String operationName) throws TechnicalException {
        if(history.getDigitalStack().size() < TWO){
            System.out.println("invalid operation: " + operationName);
            throw new TechnicalException("5002", "invalid operation");
        }
        return true;
    }
}

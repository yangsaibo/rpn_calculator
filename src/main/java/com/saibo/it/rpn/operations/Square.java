package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;
import com.saibo.it.rpn.exception.TechnicalException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class Square implements IOperate {
    private final static int ZERO = 0;

    @Override
    public void operate(OperationHistory history) {
        this.isValidOperation(history);
        MathContext mc = new MathContext(16, RoundingMode.HALF_EVEN);

        BigDecimal var1 = history.popDigitalStack();
        Stack<BigDecimal> digitalStack = new Stack<>();
        digitalStack.push(var1);
        OperationRecord record = new OperationRecord(digitalStack, this);

        history.pushDigitalStack(
                var1.sqrt(mc)
                        .setScale(10, RoundingMode.DOWN));
        history.pushOperationRecordStack(record);

    }

    private boolean isValidOperation(OperationHistory history){
        if(history.getDigitalStack().size() == ZERO){
            System.out.println("invalid operation: " + OperationEnum.SQRT.getOperationName());
            throw new TechnicalException("5002", "invalid operation");
        }
        return true;
    }
}

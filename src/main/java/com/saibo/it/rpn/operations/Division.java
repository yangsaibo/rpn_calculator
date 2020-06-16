package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division extends TwoParametersOperation implements IOperate {
    @Override
    public void operate(OperationHistory operationHistory) {
        this.isValidOperation(operationHistory, OperationEnum.DIVIDE.getOperationName());
        BigDecimal var1 = operationHistory.popDigitalStack();
        BigDecimal var2 = operationHistory.popDigitalStack();
        if(var1.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("com.saibo.it.rpn.operations.Division by zero");
        }
        OperationRecord record = this.getOperationRecord(var1,var2,this);
        operationHistory.pushOperationRecordStack(record);
        operationHistory.pushDigitalStack(var2.divide(var1, 10, RoundingMode.HALF_UP));
    }
}

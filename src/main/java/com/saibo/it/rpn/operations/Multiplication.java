package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;

import java.math.BigDecimal;

public class Multiplication extends TwoParametersOperation implements IOperate {
    @Override
    public void operate(OperationHistory operationHistory) {
        this.isValidOperation(operationHistory, OperationEnum.SUBTRACT.getOperationName());
        BigDecimal var1 = operationHistory.popDigitalStack();
        BigDecimal var2 = operationHistory.popDigitalStack();
        OperationRecord record = this.getOperationRecord(var1, var2, this);
        operationHistory.pushOperationRecordStack(record);
        operationHistory.pushDigitalStack(var1.multiply(var2));
    }
}
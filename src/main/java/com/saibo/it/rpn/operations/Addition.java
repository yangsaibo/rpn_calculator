package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;
import java.math.BigDecimal;

public class Addition extends TwoParametersOperation implements IOperate {
    @Override
    public void operate(OperationHistory operationHistory) {
        this.isValidOperation(operationHistory, OperationEnum.ADD.getOperationName());
        BigDecimal var1 = operationHistory.getDigitalStack().pop();
        BigDecimal var2 = operationHistory.getDigitalStack().pop();
        OperationRecord record = this.getOperationRecord(var1, var2, this);

        operationHistory.getRecordsStack().add(record);
        operationHistory.pushDigitalStack((var1.add(var2)));
    }
}
package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;
import com.saibo.it.rpn.exception.TechnicalException;

import java.util.Stack;

public class Clearance implements IOperate {
    private final static int ZERO = 0;

    @Override
    public void operate(OperationHistory operationHistory) {
        operationHistory.getDigitalStack().clear();
        operationHistory.getRecordsStack().clear();

        OperationRecord record = new OperationRecord(new Stack<>(), this);
        operationHistory.pushOperationRecordStack(record);
    }
}

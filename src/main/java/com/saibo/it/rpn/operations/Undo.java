package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.entity.OperationRecord;
import com.saibo.it.rpn.exception.TechnicalException;

public class Undo implements IOperate {
    private final static int ZERO = 0;

    @Override
    public void operate(OperationHistory operationHistory) {
        this.isValidOperation(operationHistory);
        OperationRecord record = operationHistory.popOperationRecordStack();
        if(!(record != null && record.getOperation() != null && record.getOperation() instanceof Clearance)){
            operationHistory.popDigitalStack();
        }
        if(record != null && record.getOperation() != null){
            operationHistory.getDigitalStack().addAll(record.getOperatedDigitalStack());
        }
    }

     private boolean isValidOperation(OperationHistory history){
        if(history.getDigitalStack().size() == ZERO && history.getRecordsStack().size() == ZERO){
            System.out.println("invalid operation: " + OperationEnum.UNDO.getOperationName());
            throw new TechnicalException("5002", "invalid operation");
        }
        return true;
    }
}

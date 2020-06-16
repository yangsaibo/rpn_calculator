package com.saibo.it.rpn.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class OperationHistory {
    private Stack<BigDecimal> digitalStack = new Stack<>();
    private Stack<OperationRecord> recordsStack = new Stack<>();

    public BigDecimal popDigitalStack(){
        if(this.digitalStack.size() == 0) return null;
        return this.digitalStack.pop();
    }

    public OperationRecord popOperationRecordStack(){
        if(this.recordsStack.size() == 0) return null;
        return this.recordsStack.pop();
    }

    public OperationRecord pushOperationRecordStack(OperationRecord record){
        return this.recordsStack.push(record);
    }

    public BigDecimal pushDigitalStack(BigDecimal val){
        return this.digitalStack.push(val);
    }
}
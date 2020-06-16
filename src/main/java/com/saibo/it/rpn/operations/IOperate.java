package com.saibo.it.rpn.operations;

import com.saibo.it.rpn.entity.OperationHistory;
import com.saibo.it.rpn.exception.TechnicalException;

public interface IOperate {
    void operate(OperationHistory OperationHistory) throws TechnicalException;
}

package com.saibo.it.rpn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.saibo.it.rpn.operations.IOperate;

import java.math.BigDecimal;
import java.util.Stack;

@Data
@AllArgsConstructor
public class OperationRecord {
    private Stack<BigDecimal> operatedDigitalStack;
    private IOperate operation;
}

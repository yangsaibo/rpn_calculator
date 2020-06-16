package com.saibo.it.rpn;

import com.saibo.it.rpn.entity.OperationEnum;
import com.saibo.it.rpn.entity.OperationHistory;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class RPNCalculator {
    private OperationHistory operationHistory;

    public RPNCalculator(){
        operationHistory = new OperationHistory();
    }

    public void calculate(String input) throws Exception {
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') continue;
            if(Character.isDigit(input.charAt(i))){
                int x = 0;
                while (Character.isDigit(input.charAt(i))){
                    x = x * 10 + (input.charAt(i) - '0');
                    if(i == input.length()-1) break;
                    i++;
                }
                operationHistory.pushDigitalStack(BigDecimal.valueOf(x));
            }else {
                StringBuilder opNameStr = new StringBuilder();
                while (!Character.isDigit(input.charAt(i)) && !Character.isSpaceChar(input.charAt(i))){
                    opNameStr.append(input.charAt(i));
                    if(i == input.length()-1) break;
                    i++;
                }
                OperationEnum.getOperation(opNameStr.toString()).operate(operationHistory);
            }
        }
        printStack(operationHistory);
    }

    private void printStack(OperationHistory operationHistory){
        System.out.print("Stack: ");
        operationHistory.getDigitalStack()
                .forEach(digital->
                    System.out.print(digital.setScale(10, RoundingMode.HALF_UP)
                            .stripTrailingZeros()
                            .toPlainString() + " ")
                );
        System.out.println();
    }


}

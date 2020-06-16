import com.saibo.it.rpn.RPNCalculator;
import com.saibo.it.rpn.exception.TechnicalException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BusinessTests {
    @Test
    public void add_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String toAddStr = "5 2 +";
        rpnCalculator.calculate(toAddStr);
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(7)))
                .isEqualTo(0);
    }

    @Test
    public void add_Successfully2() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String toAddStr = "5 22 1 + +";
        rpnCalculator.calculate(toAddStr);
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(28)))
                .isEqualTo(0);
    }

    @Test
    public void sub_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String toAddStr = "5 6 -";
        rpnCalculator.calculate(toAddStr);
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(-1)))
                .isEqualTo(0);
    }

    @Test
    public void mix_Sub_Add_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String toAddStr = "5 6 4 - +";
        rpnCalculator.calculate(toAddStr);
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(7)))
                .isEqualTo(0);
    }

    @Test
    public void multiply_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String toAddStr = "1 2 3 4 5 * * * *";
        rpnCalculator.calculate(toAddStr);
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(120)))
                .isEqualTo(0);
    }

    @Test
    public void divide_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("12 2 /");
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(6)))
                .isEqualTo(0);
    }

    @Test
    public void sqrtSuccessfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("2 sqrt");
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(1.4142135623)))
                .isEqualTo(0);
        rpnCalculator.calculate("clear 9 sqrt");
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().pop()
                .compareTo(BigDecimal.valueOf(3)))
                .isEqualTo(0);
    }

    @Test
    public void clearSuccessfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("2 sqrt");
        rpnCalculator.calculate("clear");
        assertThat(rpnCalculator.getOperationHistory().getDigitalStack().size()).isEqualTo(0);
    }

    @Test
    public void undo_Multiply_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("5 4 3 2");
        rpnCalculator.calculate("undo undo *");
        rpnCalculator.calculate("5 *");
        rpnCalculator.calculate("undo");
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(5)))
                .isEqualTo(0);
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(20)))
                .isEqualTo(0);
    }

    @Test
    public void undo_divide_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("20 4 3 2");
        rpnCalculator.calculate("undo undo /");
        rpnCalculator.calculate("5 /");
        rpnCalculator.calculate("undo");
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(5)))
                .isEqualTo(0);
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(5)))
                .isEqualTo(0);
    }

    @Test
    public void undo_add_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("20 4 3 2");
        rpnCalculator.calculate("undo undo +");
        rpnCalculator.calculate("5 +");
        rpnCalculator.calculate("undo");
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(5)))
                .isEqualTo(0);
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(24)))
                .isEqualTo(0);
    }

    @Test
    public void undo_sub_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("20 4 3 2");
        rpnCalculator.calculate("undo undo -");
        rpnCalculator.calculate("5 -");
        rpnCalculator.calculate("undo");
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(5)))
                .isEqualTo(0);
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(16)))
                .isEqualTo(0);
    }

    @Test
    public void undo_sqrt_Successfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("20 4 3 2");
        rpnCalculator.calculate("undo undo sqrt");
        rpnCalculator.calculate("sqrt");
        rpnCalculator.calculate("undo");
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(2)))
                .isEqualTo(0);
        assertThat(rpnCalculator.getOperationHistory().popDigitalStack()
                .compareTo(BigDecimal.valueOf(20)))
                .isEqualTo(0);
    }

    @Test
    public void undo_clear() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("20 4 3 2");
        rpnCalculator.calculate("undo undo clear");
    }

    @Test
    public void add_unSuccessfully1() throws Exception {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.calculate("5 2 +");
        assertThatExceptionOfType(TechnicalException.class).isThrownBy(()->rpnCalculator.calculate("+"));
    }
}

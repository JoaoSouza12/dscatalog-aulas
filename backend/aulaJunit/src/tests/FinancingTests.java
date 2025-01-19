import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinancingTests {
    @Test
    public void constuctorShouCreateObjectWhenValidData() {
        Double totalAmount = 100000.0;
        Double income = 5000.0;
        Integer months = 60;

        Financing financing = new Financing(totalAmount, income, months);

        assertEquals(totalAmount, financing.getTotalAmount());
        assertEquals(income, financing.getIncome());
        assertEquals(months, financing.getMonths());
    }
    @Test
    public void constuctorSholdThrowExceptionWhenInvalidData(){
        Double totalAmount  = 100000.0;
        Double income = 2000.0;
        Integer months = 20;

        assertThrows(IllegalArgumentException.class, () -> {
            new Financing(totalAmount, income, months);

        });
    }
    @Test
    public void setTotalAmountShouldValueWhenValidData() {
        Financing financing = new Financing(90000.0, 2000.0, 80);
        financing.setTotalAmount(80000.0); // Configuração do teste
        assertEquals(80000.0, financing.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldThrowExceptionWhenInvalidData() {
        // Arrange
        Financing financing = new Financing(100000.0, 5000.0, 40);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            financing.setTotalAmount(160000.0); // Este valor deve violar a regra de validação
        });
    }

    @Test
    public void setIncomeShouldValueWhenValidData(){
        Financing financing = new Financing(100000.0, 5000.0, 60);
        financing.setIncome(6000.0);
        assertEquals(6000.0, financing.getIncome());
    }
    @Test
    public void setIncomeShouldThrowExceptionWhenInvalidData(){
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(100000.0, 5000.0, 60);
            financing.setIncome(2000.0);
        });
    }
    @Test
    public void setMonthsShouldValueWhenValidData(){
        Financing financing = new Financing(100000.0, 5000.0, 60);
        financing.setMonths(70);
        assertEquals(70, financing.getMonths());
    }
    @Test
    public void setMonthsShouldThrowExceptionWhenInvalidData(){
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(100000.0, 5000.0, 60);
            financing.setMonths(10);
        });
    }
    @Test
    public void entryShouldReturnTwentyPercentOfTotalAmount(){
        Financing financing = new Financing(100000.0, 5000.0, 60);
        assertEquals(20000.0, financing.entry());
    }

    @Test
    public void quotaShouldReturnCorrectValue() {
        Financing financing = new Financing(100000.0, 5000.0, 60);
        assertEquals(1333.33, financing.quota(), 0.01); // Ajuste o valor esperado com base na lógica final
    }



}

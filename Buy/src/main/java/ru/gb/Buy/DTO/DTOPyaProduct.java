package ru.gb.Buy.DTO;

import lombok.Data;
import ru.gb.Buy.model.enums.BankMethodPayment;

import java.math.BigDecimal;

/**
 * Класс с передаваемой информацией для совершения оплаты
 */
@Data
public class DTOPyaProduct {
    private Long idUser;
    private BigDecimal amount;
    private String bankMethodPayment;
}

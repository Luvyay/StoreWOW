package ru.gb.Buy.service;

import org.springframework.transaction.annotation.Transactional;
import ru.gb.Buy.DTO.DTOPyaProduct;
import ru.gb.Buy.model.ResponsePay;

public interface MethodPayment {
    @Transactional
    ResponsePay pay(DTOPyaProduct dtoPyaProduct);
}

package ru.gb.FigurineStore.service.restPay;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.FigurineStore.aspect.TrackUserAction;
import ru.gb.FigurineStore.model.restPay.DTO.DTOPyaProduct;
import ru.gb.FigurineStore.model.restPay.ResponsePay;

/**
 * Класс по совершению запроса на сервер по оплате товара с передачей данных
 */
@Service
public class PayProductServiceApi {
    @Autowired
    private RestTemplate template;
    @Autowired
    private HttpHeaders headers;

    /**
     * Метод по совершению связи с сервером по оплате товаров и совершения оплаты
     * На методе есть аннотация @TrackUserAction. Она выявляет время выполнения и логирует
     * @param url
     * @param dtoPyaProduct
     * @return
     */
    @TrackUserAction
    public ResponsePay pay(String url, DTOPyaProduct dtoPyaProduct) {
        // Конвертирование dtoPyaProduct в JSON
        JSONObject dtoPayProductJsonObject = new JSONObject();
        dtoPayProductJsonObject.put("idUser", dtoPyaProduct.getIdUser());
        dtoPayProductJsonObject.put("amount", dtoPyaProduct.getAmount());
        dtoPayProductJsonObject.put("bankMethodPayment", dtoPyaProduct.getBankMethodPayment());

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(dtoPayProductJsonObject.toString(), headers);

        // Совершение связи между клиентом и сервером с оплатой товаров
        ResponseEntity<ResponsePay> response = template.exchange(url, HttpMethod.POST, entity, ResponsePay.class);

        return response.getBody();
    }
}

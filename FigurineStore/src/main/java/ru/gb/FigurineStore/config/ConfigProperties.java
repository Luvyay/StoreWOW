package ru.gb.FigurineStore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Добавление ссылки из application.yaml на API для оплаты товара
 */
@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class ConfigProperties {
    private String API_PAY;
}

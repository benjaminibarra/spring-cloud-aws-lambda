package com.springcloud.function.awslambda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="CURRENCY_EXCHANGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyTo;
    private String currencyFrom;
    private BigDecimal conversionMultiple;
}

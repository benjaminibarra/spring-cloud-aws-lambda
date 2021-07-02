package com.springcloud.function.awslambda.service;
import com.springcloud.function.awslambda.entity.CurrencyExchange;
import com.springcloud.function.awslambda.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    public List<CurrencyExchange> findAllCurrencyExchange () {
        return currencyExchangeRepository.findAll();
    }

    public Optional<CurrencyExchange> findCurrencyExchangeById (Long id) {
        return currencyExchangeRepository.findById(id);
    }

    public CurrencyExchange addCurrencyExchange (CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    public CurrencyExchange updateCurrencyExchange (CurrencyExchange currencyExchange) {
        CurrencyExchange currencyExchange1 = currencyExchangeRepository.findById(currencyExchange.getId()).orElse(null);
        if (currencyExchange1 != null) {
            return currencyExchangeRepository.save(currencyExchange);
        }
        return null;
    }

    public CurrencyExchange deleteCurrencyExchange (Long id) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findById(id).orElse(null);
        if (currencyExchange != null) {
            currencyExchangeRepository.deleteById(id);
        }
        return currencyExchange;
    }
}

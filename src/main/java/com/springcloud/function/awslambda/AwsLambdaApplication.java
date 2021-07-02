package com.springcloud.function.awslambda;

import com.springcloud.function.awslambda.entity.CurrencyExchange;
import com.springcloud.function.awslambda.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class AwsLambdaApplication {

	@Autowired
	CurrencyExchangeService currencyExchangeService;

	public static void main(String[] args) {
		FunctionalSpringApplication.run(AwsLambdaApplication.class, args);
	}

	@Bean
	public Function<Long, ResponseEntity<CurrencyExchange>> getCurrencyExchange () {
		return (input) -> ResponseEntity.of(currencyExchangeService.findCurrencyExchangeById(input));
	}

	@Bean
	public Supplier<ResponseEntity<List<CurrencyExchange>>> getAllCurrencyExchange () {
		return () -> ResponseEntity.of(Optional.of(currencyExchangeService.findAllCurrencyExchange()));
	}

	@Bean
	public Function<Long, ResponseEntity> deleteCurrencyExchange () {
		return (id) -> (currencyExchangeService.deleteCurrencyExchange(id) == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().build());
	}

	@Bean
	public Function<CurrencyExchange, ResponseEntity> updateCurrencyExchange () {
		return (currencyExchange) -> (currencyExchangeService.updateCurrencyExchange(currencyExchange) == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(currencyExchange));
	}

	@Bean
	public Function<CurrencyExchange, ResponseEntity> postCurrencyExchange () {
		return (currencyExchange) -> (ResponseEntity.ok(currencyExchangeService.addCurrencyExchange(currencyExchange)));
	}

}

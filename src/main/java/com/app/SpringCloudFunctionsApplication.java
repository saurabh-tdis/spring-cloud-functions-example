package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionsApplication.class, args);
	}


	/**
	 *
	 *
	 * curl localhost:8080/uppercase -H "Content-Type: text/plain" -d "testing"
	 *
	 * @return
	 */
	@Bean
	public Function<String,String> reverse(){
		// gets the input and perform action
		//returns function, Function<T,R> --> R apply(T t);  converted to lambda

		return (input)->new StringBuilder(input).reverse().toString();
	}

	/***
	 *
	 * curl localhost:8080/upperCase -H "Content-Type: text/plain" -d "testing"
	 * @return
	 */
	@Bean
	public Supplier<String> upperCase(){
		// gets the input and perform action
		//returns Supplier, Supplier<T> --> T get();  converted to lambda

		return ()->"returns some data";
	}

	/***
	 *
	 * curl localhost:8080/print -H "Content-Type: text/plain" -d "testing"
	 * @return
	 */
	@Bean
	public Consumer<String> print(){
		// gets the input and perform action
		//returns Consumer, Consumer<T> --> void accept(T t);  converted to lambda

		return System.out::println;
	}

	/***
	 *
	 * curl localhost:8080/wordCount -H "Content-Type: text/plain" -d "check how many words are present in a sentence"
	 * @return
	 */
	@Bean
	public Function<Flux<String>, Flux<Map<String,Integer>>> wordCount(){
		// gets the input and perform action
		//returns function, Function<T,R> --> R apply(T t);  converted to lambda

		return (input)->input.window(3)
				.flatMap(f -> {
					return f.flatMap(phrase -> Flux.fromArray(phrase.split("\\W")))
							.reduce(new HashMap<String, Integer>(), (map, word) -> { map.merge(word, 1, Integer::sum); return map; });
				});
	}

	/***
	 *
	 * curl localhost:8080/upperCaseFlux -H "Content-Type: text/plain" -d "check test"
	 * @return
	 */
	@Bean
	public Supplier<Flux<String>> upperCaseFlux(){
		// gets the input and perform action
		//returns Supplier, Supplier<T> --> T get();  converted to lambda

		return ()->Flux.just("returns some data","using flux ","supplier");
	}

	/***
	 *
	 * curl localhost:8080/printMono -H "Content-Type: text/plain" -d "check test"
	 * @return
	 */
	@Bean
	public Consumer<Flux<String>> printMono(){
		// gets the input and perform action
		//returns Consumer, Consumer<T> --> void accept(T t);  converted to lambda

		return (input)->input.doOnNext(System.out::println).subscribe();
	}






}

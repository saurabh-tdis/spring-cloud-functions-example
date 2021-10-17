package com.app.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author Saurabh Vaish
 * @Date 17-10-2021
 *
 *
 *  This is the example of defining functions in package called functions that will be automatically get scaned
 *
 */

@Configuration
public class SampleFunction {


    /**
     * curl localhost:8080/sampleReverse -H "Content-Type: text/plain" -d "testing"
     *
     */
    @Bean
    public Function<String,String> sampleReverse(){
        // gets the input and perform action
        //returns function, Function<T,R> --> R apply(T t);  converted to lambda

        return (input)->new StringBuilder(input).reverse().toString();
    }

}

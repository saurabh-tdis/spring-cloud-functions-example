package com.app.custompkg;

import java.util.function.Function;

/**
 * @author Saurabh Vaish
 * @Date 17-10-2021
 *
 *  Example of functions define in class and in custom package
 *  Example of functions that can have pojo also
 *
 *  For calling need to use class name
 *
 *  call post request with Foo class data and get response
 *
 */
public class TestPackage implements Function<Foo, Bar> {


    // getting value from Foo class and returning bar class obj
    @Override
    public Bar apply(Foo t) {
        return new Bar(t.getValue().toUpperCase());
    }
}


class Foo {

    private String value;

    Foo() {
    }

    Foo(String value) {
        this.value = value;
    }

    public String lowercase() {
        return this.value.toLowerCase();
    }

    public String uppercase() {
        return this.value.toUpperCase();
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

class Bar {

    private String value;

    Bar() {
    }

    Bar(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
package poc.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017\u00a8\u0006\u0005"}, d2 = {"Lpoc/controller/HelloWorldController;", "", "()V", "helloWorld", "", "poc"})
@io.micronaut.runtime.context.scope.Refreshable()
@io.micronaut.http.annotation.Controller(value = "hello")
public class HelloWorldController {
    
    @org.jetbrains.annotations.NotNull()
    @io.micronaut.http.annotation.Get(value = "/", produces = {"text/plain"})
    public java.lang.String helloWorld() {
        return null;
    }
    
    public HelloWorldController() {
        super();
    }
}
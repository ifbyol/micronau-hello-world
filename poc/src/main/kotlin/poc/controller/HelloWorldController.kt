package poc.controller

import io.micronaut.context.annotation.Value
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.context.scope.Refreshable


@Controller("hello")
@Refreshable
class HelloWorldController {

    @Get("/", produces = [MediaType.TEXT_PLAIN])
    fun helloWorld(): String = "Hello World!"
}
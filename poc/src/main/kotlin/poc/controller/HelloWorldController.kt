package poc.controller

import io.micronaut.context.annotation.Value
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.context.scope.Refreshable


@Controller("hello")
@Refreshable
class HelloWorldController {

    @Value("\${consul.message}")
    var consulMessage: String? = "Init consul message"

    @Value("\${externalFile.message}")
    var externalFileMessage: String? = "Init external message"

    @Get("/", produces = [MediaType.TEXT_PLAIN])
    fun helloWorld(): String = "Consul message: $consulMessage\nExternal file message: $externalFileMessage"
}
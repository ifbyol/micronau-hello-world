package poc

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("poc")
                .mainClass(Application.javaClass)
                .start()
    }
}
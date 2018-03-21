package com.kamontat

import java.util.Arrays
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext


@SpringBootApplication
open class Application {
//    @Bean
//    open fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
//        return CommandLineRunner {
//            println("Let's inspect the beans provided by Spring Boot:")
//            val beanNames = ctx.beanDefinitionNames
//            Arrays.sort(beanNames)
//            for (beanName in beanNames) {
    // println(beanName)
//            }
//        }
//    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

}
package com.example.messagingapp.person

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersonConfig {

    @Bean
    fun run(USER_REPO: PersonRepository): CommandLineRunner {
        return CommandLineRunner { _ ->
            val user1 = Person(
                firstName = "Dan",
                lastName = "Borah",
            )

            USER_REPO.save(user1)
        }

    }
}
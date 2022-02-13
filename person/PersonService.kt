package com.example.messagingapp.person

import org.springframework.stereotype.Service

@Service
class PersonService(val USER_REPO: PersonRepository) {

    /*****************
     * GET FUNCTIONS *
     *****************/

    fun getUsers(): List<Person> {
        return USER_REPO.findAll()
    }
}
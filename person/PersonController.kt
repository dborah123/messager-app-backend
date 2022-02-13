package com.example.messagingapp.person

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["person"])
class PersonController (@Autowired val USER_SERVICE: PersonService){

    /****************
     * GET MAPPINGS *
     ****************/

    @GetMapping
    fun getUsers(): List<Person>{
        return USER_SERVICE.getUsers()
    }
}
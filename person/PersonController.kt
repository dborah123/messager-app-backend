package com.example.messagingapp.person

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["person"])
class PersonController (@Autowired val PERSON_SERVICE: PersonService){

    /****************
     * GET MAPPINGS *
     ****************/

    @GetMapping
    fun getPeople(): List<Person>{
        return PERSON_SERVICE.getPerson()
    }

    @GetMapping("/people/")
    fun getSpecificPeople(
        @RequestParam(required = false) id: Long?,
        @RequestParam(required = false) firstName: String?,
        @RequestParam(required = false) lastName: String?
    ): List<Person> {
        return PERSON_SERVICE.getSpecificPeople(id, firstName, lastName)
    }

    @GetMapping("/person/")
    fun getPerson(
        @RequestParam(required = false) id: Long?,
        @RequestParam(required = false) firstName: String?,
        @RequestParam(required = false) lastName: String?
    ): Person? {
        return PERSON_SERVICE.getPerson(id, firstName, lastName)
    }
}
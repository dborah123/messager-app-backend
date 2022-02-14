package com.example.messagingapp.person

import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class PersonService(val PERSON_REPO: PersonRepository) {

    private val logger = KotlinLogging.logger {}


    /*****************
     * GET FUNCTIONS *
     *****************/

    fun getPerson(): List<Person> {
        /**
         * Gets all people in database
         */
        return PERSON_REPO.findAll()
    }

    fun getSpecificPeople(id: Long?, firstName: String?, lastName: String?): List<Person> {
        /**
         * Gets specific people from database (Can be multiple)
         */
        return PERSON_REPO.getSpecificPeople(id, firstName, lastName)
    }

    fun getPerson(id: Long?, firstName: String?, lastName: String?): Person? {
        /**
         * Gets a singular person
         */
        val person = PERSON_REPO.getSpecificPeople(id, firstName, lastName)

        if (person.isEmpty()) {
            return null
        } else if (person.size > 1) {
            logger.error {
                "More than one person with " +
                "id $id, firstname $firstName, and lastname $lastName"
            }
            throw Exception(
                "More than one person with " +
                "id $id, firstname $firstName, and lastname $lastName"
            )
        }

        return person[0]
    }
}
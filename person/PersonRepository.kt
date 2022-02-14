package com.example.messagingapp.person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE "
    + "(:id = null OR p.id = :id) "
    + "AND (:firstname = null OR p.firstName = :firstname) "
    + "AND (:lastname = null OR p.lastName = :lastname)"
    )
    fun getSpecificPeople(
        @Param("id") id: Long?,
        @Param("firstname") firstName: String?,
        @Param("lastname") lastName: String?,
    ): List<Person>
}
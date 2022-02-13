package com.example.messagingapp.person

import com.example.messagingapp.messagethread.MessageThread
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "person")
class Person(
    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    val id: Long? = null,
    var firstName: String,
    var lastName: String,
    @JsonIgnore
    @ManyToMany(
        mappedBy = "people",
        fetch = FetchType.LAZY
    )
    val threads: MutableSet<MessageThread> = mutableSetOf(),
    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    var contacts: MutableList<Person> = mutableListOf()
) {

}
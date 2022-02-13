package com.example.messagingapp.messagethread

import com.example.messagingapp.message.Message
import javax.persistence.*

@Entity
@Table(name = "messagethread")
class MessageThread(
    @Id
    @SequenceGenerator(
        name = "messagethread_sequence",
        sequenceName = "messagethread_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "messagethread_sequence"
    )
    var id: Long? = null,

//    @ManyToMany(
//       fetch = FetchType.LAZY
//    )
//    @JoinTable(
//        name = "people_threads",
//        joinColumns = [JoinColumn(name = "thread_id")],
//        inverseJoinColumns = [JoinColumn(name = "person_id")]
//    )
//    val people: MutableSet<Person> = mutableSetOf(),
    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    var messages: MutableList<Message> = mutableListOf()
) {

}
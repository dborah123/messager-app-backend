package com.example.messagingapp.message

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "message")
class Message(
    @Id
    @SequenceGenerator(
        name = "message_sequence",
        sequenceName = "message_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "message_sequence"
    )
    var id: Long? = null,
    thread: Thread,
    content: String,
    dateTime: LocalDateTime
) {


}
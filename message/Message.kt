package com.example.messagingapp.message

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "message")
class Message(
    thread: Thread,
    content: String,
    dateTime: LocalDateTime
) {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "message_sequence"
    )
    @SequenceGenerator(
        name = "message_sequence",
        sequenceName = "message_sequence",
        allocationSize = 1
    )
    @Column(
        name = "id",
        nullable = false
    )
    open var id: Long? = null

}
package com.example.messagingapp.thread

import com.example.messagingapp.message.Message
import com.example.messagingapp.user.User
import javax.persistence.*

@Entity
@Table(name = "thread")
class Thread(
    @ManyToMany(
       fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "usersInThread",
        joinColumns = [JoinColumn(name = "thread_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    val users: MutableSet<User>,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var messages: MutableList<Message>
) {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "thread_sequence"
    )
    @SequenceGenerator(
        name = "thread_sequence",
        sequenceName = "thread_sequence",
        allocationSize = 1
    )
    @Column(
        name = "id",
        nullable = false
    )
    open var id: Long? = null

}
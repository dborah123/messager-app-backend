package com.example.messagingapp.user

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    var firstName: String,
    var lastName: String,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var threads: MutableList<Thread>
) {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @Column(
        name = "id",
        nullable = false
    )
    open var id: Long? = null;

}
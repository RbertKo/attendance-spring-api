package com.example.attendanceapimono.domain.user

import java.io.Serializable
import javax.persistence.*

enum class SocialType {
    GOOGLE
}

@Entity
@Table(name = "social_providers")
class SocialProvider(id: String, type: SocialType, user: User): Serializable {
    @Id
    @Column(length = 30)
    val id: String = id;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    val type: SocialType = type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id") // user.id
    val user: User = user;
}
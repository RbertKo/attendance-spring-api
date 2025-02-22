package com.example.attendanceapimono.domain.user

import com.example.attendanceapimono.domain.attendance.Attendance
import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

enum class UserState {
    // 추가 필요
    NORMAL
}

enum class UserRole {
    MASTER, STAFF, MEMBER
}

enum class UserPosition {
    DESIGNER, ANDROID, IOS, FRONTEND, BACKEND
}

@Entity
@Table(name = "users")
class User(
    @Id
    @Type(type="uuid-char")
    @Column(columnDefinition = "CHAR(36)")
    val id: UUID,

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    var state: UserState,

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    var role: UserRole,

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    var position: UserPosition,

    @Column(nullable = false)
    var generationID: Int,

    @Column(length = 20, nullable = false)
    var firstName: String,

    @Column(length = 20, nullable = false)
    var lastName: String,

    @Column(length = 320, nullable = false)
    var email: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    @Column(nullable = false)
    var updatedAt: LocalDateTime,

    @OneToMany(mappedBy = "user")
    val socialProviders: List<SocialProvider> = arrayListOf(),

    @OneToMany(mappedBy = "user")
    val attendances: List<Attendance> = arrayListOf()
)
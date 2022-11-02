package ru.tim.chatmessenger.data.account

import ru.tim.chatmessenger.domain.type.Either
import ru.tim.chatmessenger.domain.type.None
import ru.tim.chatmessenger.domain.type.exception.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}
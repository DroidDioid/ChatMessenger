package ru.tim.chatmessenger.data.account

import ru.tim.chatmessenger.domain.type.Either
import ru.tim.chatmessenger.domain.type.None
import ru.tim.chatmessenger.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}
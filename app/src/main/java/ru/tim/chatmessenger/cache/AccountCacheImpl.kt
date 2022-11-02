package ru.tim.chatmessenger.cache

import ru.tim.chatmessenger.data.account.AccountCache
import ru.tim.chatmessenger.domain.type.Either
import ru.tim.chatmessenger.domain.type.None
import ru.tim.chatmessenger.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) :
    AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}
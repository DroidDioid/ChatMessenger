package ru.tim.chatmessenger.domain.account

import ru.tim.chatmessenger.domain.interactor.UseCase
import ru.tim.chatmessenger.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}
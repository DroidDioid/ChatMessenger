package ru.tim.chatmessenger.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.tim.chatmessenger.R
import ru.tim.chatmessenger.cache.AccountCacheImpl
import ru.tim.chatmessenger.cache.SharedPrefsManager
import ru.tim.chatmessenger.data.account.AccountRepositoryImpl
import ru.tim.chatmessenger.domain.account.AccountRepository
import ru.tim.chatmessenger.domain.account.Register
import ru.tim.chatmessenger.remote.account.AccountRemoteImpl
import ru.tim.chatmessenger.remote.core.NetworkHandler
import ru.tim.chatmessenger.remote.core.Request
import ru.tim.chatmessenger.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abkcdhg@m.com", "abcd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
package it.niko.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.niko.viewmodelscopedemo.model.User
import it.niko.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    private var userRepository = UserRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {
        viewModelScope.launch {
            var ret: List<User>?
            withContext(Dispatchers.IO) {
                ret = userRepository.getUsers()
            }
            users.value = ret
        }
    }
}
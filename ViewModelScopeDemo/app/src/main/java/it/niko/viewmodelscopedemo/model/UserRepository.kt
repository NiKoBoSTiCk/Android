package it.niko.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        return listOf(
            User(1, "Sam1"),
            User(2, "Sam2"),
            User(3, "Sam3"),
            User(4, "Sam4"),
            User(5, "Sam5"),
            User(6, "Sam6"),
            User(7, "Sam7"),
            User(8, "Sam8"),
            User(9, "Sam9"),
            User(10, "Sam10"),
            User(11, "Sam11")
        )
    }
}
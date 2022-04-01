package com.human_developing_soft.doggy.user_id

import android.content.Context

/**
 * Human Developing Soft
 *
 * @author Egor Ponomarev
 */
interface UserIdData {

    fun put(id: String)

    fun userId(): String

    class Base(
        context: Context
    ) : UserIdData {
        private val mStore = context.getSharedPreferences("userId",
            Context.MODE_PRIVATE)

        override fun put(id: String) {
            mStore.edit()
                .putString("data", id)
                .apply()
        }

        override fun userId() : String {
            val data = mStore.getString("data", "")
            return if (data != null && data.isNotEmpty()) {
                data
            } else {
                throw UserIdNotFound()
            }
        }
    }
}
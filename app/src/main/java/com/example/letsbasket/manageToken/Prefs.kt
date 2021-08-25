package com.example.letsbasket.manageToken

import android.content.Context

class Prefs(context: Context) {
    private val prefNm="mPref"
    private val prefs = context.getSharedPreferences(prefNm, Context.MODE_PRIVATE)

    var tokenVal: String?
        get() = prefs.getString("token", null)
        set(value) = prefs.edit().putString("token", value).apply()
    /* get/set 함수 임의 설정. get 실행 시 저장된 값을 반환하며 default 값은 ""
     * set(value) 실행 시 value로 값을 대체한 후 저장 */
}
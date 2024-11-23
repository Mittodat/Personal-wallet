package com.dd.personalwallet.data

import com.dd.personalwallet_core.iinterface.IResponse

data class CareEmployee(
    val name: String? = null,

    val age: Int? = null,

    val detail: String? = null
): IResponse {
    companion object {
        val fatory by lazy { arrayListOf(
            CareEmployee(name = "Nguyen Thi Dao", age = 43, detail = "Chăm sóc như người thân"),
            CareEmployee(name = "Luu Thi Hanh", age = 46, detail = "Chăm sóc như người thân"),
            CareEmployee(name = "Nguyen Nhu Mai", age = 56, detail = "Chăm sóc như người thân"),
            CareEmployee(name = "Nguyen Thi Vi", age = 50, detail = "Chăm sóc như người thân"),
            CareEmployee(name = "Tra Thi Hai", age = 42, detail = "Chăm sóc như người thân"),
            ) }
    }
}

package com.example.yourteacher.domain.usecases.app_entry

import com.example.yourteacher.domain.usecases.LocalUserManger


class SaveAppEntry(
    private val localUserManger: LocalUserManger,
) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }

}
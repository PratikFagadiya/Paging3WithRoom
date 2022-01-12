package com.pratik.paging3withroom.ui

import androidx.paging.PagingSource
import com.pratik.paging3withroom.database.AppDao
import com.pratik.paging3withroom.database.CharacterData
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getAllRecords(): PagingSource<Int, CharacterData> {
        return appDao.getAllRecords()
    }

    fun insertRecord(characterData: CharacterData) {
        appDao.insertRecord(characterData)
    }
}
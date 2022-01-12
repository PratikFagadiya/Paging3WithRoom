package com.pratik.paging3withroom.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pratik.paging3withroom.database.objects.DatabaseConst.ID
import com.pratik.paging3withroom.database.objects.DatabaseConst.TABLE_NAME

@Dao
interface AppDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY $ID DESC")
    fun getAllRecords(): PagingSource<Int, CharacterData>

    @Insert
    fun insertRecord(characterData: CharacterData)


}
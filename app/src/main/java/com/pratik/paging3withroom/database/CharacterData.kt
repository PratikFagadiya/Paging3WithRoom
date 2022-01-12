package com.pratik.paging3withroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pratik.paging3withroom.database.objects.DatabaseConst

@Entity(tableName = DatabaseConst.TABLE_NAME)
data class CharacterData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = DatabaseConst.ID) val id: Int = 0,
    @ColumnInfo(name = DatabaseConst.NAME) val name: String
)
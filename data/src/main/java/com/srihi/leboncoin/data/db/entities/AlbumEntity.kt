package com.srihi.leboncoin.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ALBUM_TABLE = "albums"
const val ALBUM_ALBUMID = "albumId"
const val ALBUM_ID = "id"
const val ALBUM_TITLE = "title"
const val ALBUM_URL = "url"
const val ALBUM_THUMBNAILURL = "thumbnailUrl"

/**
 * Database table Entity
 */

@Entity(tableName = ALBUM_TABLE)
data class AlbumEntity(
    @PrimaryKey
    @ColumnInfo(name = ALBUM_ALBUMID)
    val albumID: Long,
    @ColumnInfo(name = ALBUM_ID)
    val id: Long,
    @ColumnInfo(name = ALBUM_TITLE)
    val title: String,
    @ColumnInfo(name = ALBUM_URL)
    val url: String,
    @ColumnInfo(name = ALBUM_THUMBNAILURL)
    val thumbnailUrl: String
)
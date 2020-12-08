package com.srihi.leboncoin.data.db

import com.srihi.leboncoin.data.db.entities.AlbumEntity
import com.srihi.leboncoin.domain.model.Album

fun mapDataToEntity(album: Album): AlbumEntity = AlbumEntity(
    albumID = album.albumId,
    id = album.id,
    title = album.title,
    url = album.url,
    thumbnailUrl = album.thumbnailUrl
)

fun mapDataToEntities(albums: List<Album>): List<AlbumEntity> {
    val albumsList = mutableListOf<AlbumEntity>()
    for (album: Album in albums) {
        albumsList.add(mapDataToEntity(album))
    }
    return albumsList
}

fun mapEntityToData(albumEntity: AlbumEntity): Album = Album(
    albumId = albumEntity.albumID,
    id = albumEntity.id,
    title = albumEntity.title,
    url = albumEntity.url,
    thumbnailUrl = albumEntity.thumbnailUrl
)

fun mapEntitiesToData(albumEntities: List<AlbumEntity>): List<Album> {
    val albumsList = mutableListOf<Album>()
    for (album: AlbumEntity in albumEntities) {
        albumsList.add(mapEntityToData(album))
    }
    return albumsList
}
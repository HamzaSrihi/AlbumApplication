package com.srihi.leboncoin.domain.model

/**
 * Album data class
 *
 * @property albumId
 * @property id
 * @property title
 * @property url
 * @property thumbnailUrl
 */
data class Album(
    val albumId: Long,
    val id: Long,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
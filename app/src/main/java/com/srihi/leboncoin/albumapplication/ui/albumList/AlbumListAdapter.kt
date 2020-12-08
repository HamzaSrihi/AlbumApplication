package com.srihi.leboncoin.albumapplication.ui.albumList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.srihi.leboncoin.albumapplication.R
import com.srihi.leboncoin.domain.model.Album

class AlbumListAdapter (context: Context) :
    RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    var albums: List<Album> = ArrayList()


    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getAlbum(position))
    }


    private fun getAlbum(position: Int): Album = albums[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val holder = AlbumViewHolder(inflater.inflate(R.layout.list_item, parent, false))
        return holder
    }


    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextViex = itemView.findViewById<TextView>(R.id.title)
        private val imageView = itemView.findViewById<ImageView>(R.id.album_image)
        var url: String? = null

        fun bind(album: Album) {
            titleTextViex.text = album.title
            imageView.load(album.thumbnailUrl)

        }
    }

}
package com.srihi.leboncoin.albumapplication.ui.albumList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.srihi.leboncoin.albumapplication.R
import com.srihi.leboncoin.domain.model.Album

import timber.log.Timber
import kotlinx.android.synthetic.main.fragment_album_list.*


class AlbumListFragment : Fragment() {

    private lateinit var albumsListViewModel: AlbumListViewModel
    private lateinit var albumsListAdapter: AlbumListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumsListViewModel = ViewModelProvider(this).get(AlbumListViewModel::class.java)
        albumsListAdapter = AlbumListAdapter(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView()")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        recycler_view_albums_list.layoutManager = LinearLayoutManager(context)
        recycler_view_albums_list.adapter = albumsListAdapter
    }

    private fun initObservers() {
        albumsListViewModel.itemsFragmentState.observe(
            viewLifecycleOwner,
            Observer { state -> onStateChange(state) })
    }

    private fun onStateChange(fragmentState: FragmentState) =
        when (fragmentState) {
            FragmentState.Loading -> showLoadingState()
            is FragmentState.Loaded -> showLoadedState(fragmentState)
            is FragmentState.Error -> showErrorState(fragmentState)
        }

    private fun showLoadingState() {
        Timber.i("Loading state")
        progress_bar_loading_items.visibility = View.VISIBLE
    }

    private fun showLoadedState(loaded: FragmentState.Loaded) {
        Timber.i("Loaded state")
        progress_bar_loading_items.visibility = View.GONE

        albumsListAdapter.albums = loaded.albums
        albumsListAdapter.notifyDataSetChanged()
    }


    private fun showErrorState(error: FragmentState.Error) {
        Timber.e("error ${error.message}")
        progress_bar_loading_items.visibility = View.GONE
    }

    sealed class FragmentState {
        object Loading : FragmentState()
        class Loaded(val albums: List<Album>) : FragmentState()
        class Error(val message: String) : FragmentState()
    }
}
package com.srihi.leboncoin.albumapplication.ui.albumList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srihi.leboncoin.albumapplication.ui.albumList.AlbumListViewModel.useCaseInstance.getAlbumUseCase
import com.srihi.leboncoin.domain.model.Album
import com.srihi.leboncoin.domain.usecase.GetAlbumList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class AlbumListViewModel (application: Application) : AndroidViewModel(application) {

    private var disposable: Disposable? = null

    object useCaseInstance : KoinComponent {
        val getAlbumUseCase : GetAlbumList by inject()
    }

    private val _itemsFragmentState = MutableLiveData<AlbumListFragment.FragmentState>()
    val itemsFragmentState: LiveData<AlbumListFragment.FragmentState> = _itemsFragmentState

    init {
        Timber.i("new instance")

        _itemsFragmentState.value = AlbumListFragment.FragmentState.Loading

        disposable = loadAlbums()
    }

    private fun loadAlbums() = getAlbumUseCase.execute()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(::onSuccess, ::onError)

    private fun onSuccess(albums: List<Album>) {
        _itemsFragmentState.value = AlbumListFragment.FragmentState.Loaded(albums)
    }

    private fun onError(throwable: Throwable) {
        _itemsFragmentState.value = AlbumListFragment.FragmentState.Error(throwable.toString())
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}
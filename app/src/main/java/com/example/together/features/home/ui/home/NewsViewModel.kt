package com.example.together.features.home.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.newsLine.PostRepository
import com.example.together.data.api.newsLine.model.Post
import com.example.together.features.utils.createEmptySingle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class NewsViewModel(
    private val postRepository: PostRepository,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    companion object {
        private val TAG = "NewsViewModel"
    }
    val posts = MutableLiveData<List<Post>>()
    fun updatePosts() {
        postRepository
            .getNewsLine()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe( { it ->
                posts.value = it
            }, {
                Timber.tag(TAG).e(it)
            }).also { compositeDisposable.add(it) }
    }
}
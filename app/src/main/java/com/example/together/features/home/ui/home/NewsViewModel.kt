package com.example.together.features.home.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.newsLine.PostRepository
import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.newsLine.model.Post
import com.example.together.data.api.user.model.Profile
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
    val posts = MutableLiveData<MutableList<Post>>()
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

    fun createPost(text: String) {
        posts.value = posts.value.apply {
            this!!.add(0, Post(
                "somePostId",
                text,
                "22.06.2021",
                230,
                15,
                Profile(
                    "8274278348273",
                    "Ник",
                    "Рутович",
                    "https://sun9-66.userapi.com/impf/c637227/v637227071/511b9/9bHHnpkD8r8.jpg?size=512x512&quality=96&proxy=1&sign=649b43e820821859da6ef196073f0c77&type=album",
                    "Админ",
                    -1,
                    12,
                    12,
                    Position(
                        "gdukfgjlfds",
                        51.771718,
                        55.140528
                    )
                )
            ))
        }
    }
}
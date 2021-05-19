package com.example.together.features.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.data.api.newsLine.PostRepository
import io.reactivex.disposables.CompositeDisposable

class NewsViewModelFactory(
    private val postRepository: PostRepository,
    private val compositeDisposable: CompositeDisposable
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            postRepository,
            compositeDisposable
        ) as T
    }
}
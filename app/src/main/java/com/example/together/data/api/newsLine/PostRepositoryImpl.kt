package com.example.together.data.api.newsLine

import com.example.together.data.api.newsLine.api.PostApi
import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.newsLine.model.Post
import com.example.together.data.api.user.model.Profile
import com.example.together.domain.userdata.AccountHolder
import com.example.together.features.utils.createEmptySingle
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber

class PostRepositoryImpl(
    private val postApi: PostApi,
    private val accountHolder: AccountHolder
): PostRepository {
    companion object {
        const val TAG = "PostRepositoryImpl"
    }
    override fun getNewsLine(): Single<MutableList<Post>> {
        return Single.just(
            mutableListOf(
            Post(
                "somePostId",
                "11 апреля будет проходить студ. весна в ОГУ.\n" +
                        "Приглашаем всех желающих!",
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
            ),
            Post(
                "somePostId",
                "А бек умер",
                "21.06.2021",
                1,
                1,
                Profile(
                    "8274278348273",
                    "Данил",
                    "Кринж",
                    "https://vk.com/images/camera_200.png",
                    "Дед инсайд",
                    -1,
                    12,
                    12,
                    Position(
                        "gdukfgjlfds",
                        51.771718,
                        55.140528
                    )
                )
            ),
            Post(
                "somePostId",
                "Доброго вечера! Как у вас дела?",
                "1.04.2021",
                13,
                0,
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
            ),
        )
        )
    }

    override fun getUserNews(): Single<List<Post>> {
        return Single.just(listOf(
            Post(
                "somePostId",
                "11 апреля будет проходить студ. весна в ОГУ.\n" +
                        "Приглашаем всех желающих!",
                "5.04.2021",
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
            ),
            Post(
                "somePostId",
                "Доброго вечера! Как у вас дела?",
                "1.04.2021",
                13,
                0,
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
            ),
        ))
    }

    override fun createPost(text: String): Single<Completable> {
        return postApi.createPost("Bearer ${accountHolder.accessData!!.access_token}", text)
    }
}
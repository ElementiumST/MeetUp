package com.example.together.data.api.newsLine

import com.example.together.data.api.newsLine.api.PostApi
import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.newsLine.model.Post
import com.example.together.data.api.user.model.Profile
import io.reactivex.Single

class PostRepositoryImpl(
    private val postApi: PostApi
): PostRepository {
    override fun getNewsLine(): Single<List<Post>> {
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
            Post(
                "somePostId",
                "Я стану хокаге!",
                "14.03.2021",
                14030,
                1030,
                Profile(
                    "8274278348273",
                    "Наруто",
                    "Узумаки",
                    "https://sun9-76.userapi.com/impg/a-1DVpJv0usrZ47hEHoNS847Vn2LGO91TdyS-A/vt6qrtOKdlk.jpg?size=767x629&quality=96&sign=8566c19ad36bbd3c26bbac26728e98b4&type=album",
                    "Будущий хокаге",
                    704,
                    0,
                    0,
                    Position(
                        "gdukfgjlfds",
                        51.771718,
                        55.140528
                    )
                )
            )
        ))
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
}
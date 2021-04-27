package com.example.together.data.testRetrofit.travels

import com.example.together.data.testRetrofit.model.Position
import com.example.together.data.testRetrofit.model.Post
import com.example.together.data.testRetrofit.travels.api.TravelsApi
import com.example.together.data.testRetrofit.travels.model.Tag
import com.example.together.data.testRetrofit.travels.model.Travel
import com.example.together.data.testRetrofit.user.model.Profile
import io.reactivex.Single

class TravelsRepositoryImpl(
        private val travelsApi: TravelsApi
) : TravelsRepository {
    override fun getMapTravels(): Single<List<Travel>> {
        val travels = listOf(
                Travel(
                        null,
                        Position("", 51.7806424, 55.1142945),
                        "Студенческая весна в ОГУ",
                        listOf(),
                        "11.04.2021",
                        listOf(
                                Tag("", "Официальное"),
                                Tag("", "Публичное"),
                        ),
                        listOf("https://www.osu.ru/img/event/2017/2017_08_25/01.jpg",
                        "https://www.osu.ru/img/event/2017/2017_03_20/01.jpg",
                        "https://www.osu.ru/img/event/2017/2017_05_18/01.jpg",
                        "https://pbs.twimg.com/media/ELAR-XrX0AAx03t.jpg"),
                        null,
                        Post(
                                "somePostId",
                                "11 апреля будет проходить студ. весна в ОГУ.\n" +
                                        "Приглашаем всех желающих!",
                                "5.04.2021",
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
                        )



                )
        )
        return Single.just(travels)
    }

}
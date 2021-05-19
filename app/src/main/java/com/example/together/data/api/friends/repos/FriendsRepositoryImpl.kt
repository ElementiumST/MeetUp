package com.example.together.data.api.friends.repos

import com.example.together.data.api.friends.api.FriendsApi
import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.user.model.Profile
import io.reactivex.Single

class FriendsRepositoryImpl(
    private val friendsApi: FriendsApi
): FriendsRepository {
    override fun getFriendsOfUser(): Single<List<Profile>> {
        return Single.just(listOf(
            Profile(
                "8274278348273",
                "Данил",
                "Кринж",
                "https://vk.com/images/camera_200.png",
                "",
                1,
                0,
                0,
                Position(
                    "gdukfgjlfds",
                    51.771718,
                    55.140528
                )
            ),
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
        ))
    }
}
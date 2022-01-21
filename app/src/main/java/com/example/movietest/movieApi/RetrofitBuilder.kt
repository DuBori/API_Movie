package com.example.movietest.movieApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var baseUrl: String = "http://www.kobis.or.kr"
    var api: RetrofitMovieAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RetrofitMovieAPI::class.java)

    }
}

//Retrofit을 사용하기 위해서는 Retrofit객체를 생성해야 한다.
//보통 Retrofit 객체를 생성하는 메서드를 선언해두고 재사용한다.
//Retrofit 객체를 생성하기 위해 빌더 객체를 생성해야 하고
//필요한 설정 사항을 추가해서 빌드한다.
//kyome.tistory.com/150 호출해야 한다고 하면
//보통 'kyome.tistory.com/' 까지는 고정이고
//'150' 부분이 변하는 부분이기 때문에
//''kyome.tistory.com/'를 baseUrl로 세팅한다.

//Retrofit은 create 메서드에 Service 클래스를 넣어서 Retrofit객체를 만들었으면 클라이언트와 서버가 통신할 길을
//열렸다고 볼 수 있다. Retrofit에서 Service에 선언한 메서드를 호출하는 방식으로 통신의 길을 열 수 있다.



//출처: https://kyome.tistory.com/148 [KYOME]

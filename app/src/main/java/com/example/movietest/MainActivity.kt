package com.example.movietest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import com.example.movietest.movieApi.*
import com.example.movietest.presenter.MainActivity
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
import java.nio.file.Paths.get
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var search2: SearchView

    companion object {
        const val KEY = "bde6bdb710dd79ce245395a53ada6cf5"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn1 -> {
                // 오늘 날짜에서 하루를 뺀 날짜를 "yyyyMMdd" 형식으로 만든다.
                val cal: Calendar = Calendar.getInstance()
                cal.add(Calendar.DAY_OF_MONTH, -1)
                val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
                val targetDt = dateFormat.format(cal.time)
                getResult(targetDt)
            }
            R.id.btn2 -> {
                val intent: Intent = Intent(this@MainActivity, MainActivity::class.java)//presenter안에있는 main실행
                startActivity(intent)
            }
            R.id.btn3 -> {
                // 오늘 날짜에서 하루를 뺀 날짜를 "yyyyMMdd" 형식으로 만든다.
//                val intent: Intent = Intent(this@MainActivity, activity_result_box2::class.java)//presenter안에있는 main실행
//                startActivity(intent)
                val cal: Calendar = Calendar.getInstance()
                cal.add(Calendar.DAY_OF_MONTH, -7)
                val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
                var targetDt = dateFormat.format(cal.time)
                getResult2(targetDt)
//                search2.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//
//
//                        return true
//                    }
//
//                    override fun onQueryTextChange(newText: String?): Boolean {
//
//                        // 검색창에서 글자가 변경이 일어날 때마다 호출
//
//                        return true
//                    }
//                })

            }
        }
    }


    //안드로이드는 기본적으로 액티비티로 구성이 되어있는데요.
    //각 액티비티간에 이동하기 위해선 Intent 로 액티비티 이동을 하게됩니다.
    fun getResult(targetDt:String){
        RetrofitBuilder.api
            .getMovieList(targetDt, KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    val movieResponse = response.body()//성공시 onResponse 를 실행하고, 실패 시 onFailure를 실행
                    val list : List<MovieDto> = movieResponse!!.boxofficeResult!!.dailyBoxOfficeList
                    Log.d("MY", "$list") // 직렬화 전의 값 log로 확인
                //MY: [MovieDto(movieNm=스파이더맨: 노 웨이 홈, rankInten=0, rank=1), MovieDto(movieNm=특송, rankInten=0, rank=2), MovieDto(movieNm=씽2게더, rankInten=0, rank=3), MovieDto(movieNm=경관의 피, rankInten=0, rank=4), MovieDto(movieNm=하우스 오브 구찌, rankInten=1, rank=5), MovieDto(movieNm=웨스트 사이드 스토리, rankInten=-1, rank=6), MovieDto(movieNm=킹스맨: 퍼스트 에이전트, rankInten=0, rank=7), MovieDto(movieNm=클리포드 더 빅 레드 독, rankInten=0, rank=8), MovieDto(movieNm=비욘드라이브 더 무비 : 엔시티 레조넌스, rankInten=0, rank=9), MovieDto(movieNm=드라이브 마이 카, rankInten=1, rank=10)]
                    val intent: Intent = Intent(this@MainActivity, RankActivity::class.java) // 이곳에서 랭크엑티비티로 이동
                    //bundle -> 보따리 느낌
                    val bundle = Bundle() //Call 인터페이스는 enqueue(Callback<T> callback);메서드를 갖고 있어야한다.그러니 통신을 한 후에 받은Call<T> 객체는 enqueue가 구현된 상태라는 것이다.
                    bundle.putSerializable(
                        "movieList",
                        (list as Serializable)
                    ) //list를 강제 형변환 직렬화
                    //bundle.putString("name","홍길동")
                    //bundle.putInt("age",10)  이 두줄과 같이 put 뒤에 전달하려는 값의 자료형을 쓰면된다.
                    intent.putExtras(bundle)
                    startActivity(intent) // 이동 RankACtivity  정보를 가지고?
                }
            })
    }fun getResult2(targetDt:String){
        RetrofitBuilder2.api2
            .getMovieList(targetDt, KEY,0 )
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    val movieResponse = response.body()
                    val list2 : List<MovieDto2> = movieResponse!!.boxofficeResult!!.weeklyBoxOfficeList
                    Log.d("MY", "$list2") // 직렬화 전의 값 log로 확인
                    //MY: [MovieDto(movieNm=스파이더맨: 노 웨이 홈, rankInten=0, rank=1), MovieDto(movieNm=특송, rankInten=0, rank=2), MovieDto(movieNm=씽2게더, rankInten=0, rank=3), MovieDto(movieNm=경관의 피, rankInten=0, rank=4), MovieDto(movieNm=하우스 오브 구찌, rankInten=1, rank=5), MovieDto(movieNm=웨스트 사이드 스토리, rankInten=-1, rank=6), MovieDto(movieNm=킹스맨: 퍼스트 에이전트, rankInten=0, rank=7), MovieDto(movieNm=클리포드 더 빅 레드 독, rankInten=0, rank=8), MovieDto(movieNm=비욘드라이브 더 무비 : 엔시티 레조넌스, rankInten=0, rank=9), MovieDto(movieNm=드라이브 마이 카, rankInten=1, rank=10)]
                    val intent: Intent = Intent(this@MainActivity, RankActivity2::class.java) // 이곳에서 랭크엑티비티로 이동
                    //bundle -> 보따리 느낌
                    val bundle = Bundle()
                    bundle.putSerializable(
                        "movieList2",
                        (list2 as Serializable)
                    ) //list를 강제 형변환 직렬화
                    //bundle.putString("name","홍길동")
                    //bundle.putInt("age",10)  이 두줄과 같이 put 뒤에 전달하려는 값의 자료형을 쓰면된다.
                    intent.putExtras(bundle)
                    startActivity(intent) // 이동 RankACtivity  정보를 가지고?
                }
            })
    }
}

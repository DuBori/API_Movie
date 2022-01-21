package com.example.movietest

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movietest.movieApi.MovieDto2


class RankActivity2 : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var list2: List<MovieDto2>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_box2) // 보여주고

        recyclerView = findViewById(R.id.rv_result)  // rv_result의 접근을 위해 불러오고
        recyclerView.adapter = ResultRecyclerViewAdpater()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext) // 어떤 형태로 아이템 배치할지 결정
        val bundle = intent.extras
        list2 = bundle?.getSerializable("movieList2") as List<MovieDto2> // 객체 일차원의 데이터로 저장하는 기능
        Log.d("My", "RankActivity2의 MovieList : $list2") //로그남기기?
    //My: RankActivity의 MovieList : [MovieDto(movieNm=스파이더맨: 노 웨이 홈, rankInten=0, rank=1), MovieDto(movieNm=특송, rankInten=0, rank=2), MovieDto(movieNm=씽2게더, rankInten=0, rank=3), MovieDto(movieNm=경관의 피, rankInten=0, rank=4), MovieDto(movieNm=하우스 오브 구찌, rankInten=1, rank=5), MovieDto(movieNm=웨스트 사이드 스토리, rankInten=-1, rank=6), MovieDto(movieNm=킹스맨: 퍼스트 에이전트, rankInten=0, rank=7), MovieDto(movieNm=클리포드 더 빅 레드 독, rankInten=0, rank=8), MovieDto(movieNm=비욘드라이브 더 무비 : 엔시티 레조넌스, rankInten=0, rank=9), MovieDto(movieNm=드라이브 마이 카, rankInten=1, rank=10)]
    }// 직렬화된 후의 값들을 MovieDto에서 받아와 로그캣에서 확인할 수 있었음.

    inner class ResultRecyclerViewAdpater : RecyclerView.Adapter<ResultRecyclerViewAdpater.ResultViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultRecyclerViewAdpater.ResultViewHolder {
            //마지막 인자 -> parent에 합성(?)을 시킬지
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item2, parent, false) // 두 레이아웃을 합침
            return ResultViewHolder(view) // 객체화 하고싶은 xml파일, 객체화한 뷰를 넣을 부모 레이아웃/컨테이너, 인플레이션하고자 하는지
        } // 뷰 객체 생성역할 디자인되어 있는 레이아웃을 인자로 받아 저장하고 있는 것 여기선 10개?

        override fun getItemCount(): Int {
            return list2.size
        }

        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(
            holder: ResultRecyclerViewAdpater.ResultViewHolder,
            position: Int
        ) {
            holder.apply {
                rankTextView.text = list2[position].rank
                val rankInten = list2[position].rankInten
                rankIntenTextView.text = rankInten
                movieNameTextView.text = list2[position].movieNm
                if (rankInten?.toInt()!! < 0) { // 순위가 0보다 작으면 이미지 설정 하락 빨강
                    rankIntenImageView.setImageResource(R.drawable.ic_sort_down_solid)
                    rankIntenTextView.setTextColor(R.color.red)
                }// 순위, 이름 ,순위변동
            }
        }

        inner class ResultViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            //위의 onCreateViewHolder에서 생성된 view를 가지고 실행함
            //클래스 안의 클래스
            //item_detail의 아이들을 가지고 옴 findviewbyid 로
            val rankTextView: TextView = view.findViewById(R.id.rank)
            val movieNameTextView: TextView = view.findViewById(R.id.movie_name)
            val rankIntenTextView: TextView = view.findViewById(R.id.tv_rankInten)
            val rankIntenImageView: ImageView = view.findViewById(R.id.iv_rankInten)
        }
    }
}
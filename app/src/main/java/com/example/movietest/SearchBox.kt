package com.example.movietest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import java.io.*
import java.lang.RuntimeException
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class SearchBox : AppCompatActivity() {

    lateinit var searchv : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_box)

    }
}
//
//object ApiExamSearchBlog {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val clientId = "O9onbY5xPBKdN4J3lDpN" //애플리케이션 클라이언트 아이디값"
//        val clientSecret = "IVeF8wG65G" //애플리케이션 클라이언트 시크릿값"
//        var text: String? = null
//        text = try {
//            URLEncoder.encode("no way home", "UTF-8")
//        } catch (e: UnsupportedEncodingException) {
//            throw RuntimeException("검색어 인코딩 실패", e)
//        }
//        val apiURL =
//            "\thttps://openapi.naver.com/v1/search/movie.xml?query=${text}?&display=10" // json 결과
//        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
//        val requestHeaders: MutableMap<String, String> = HashMap()
//        requestHeaders["X-Naver-Client-Id"] = clientId
//        requestHeaders["X-Naver-Client-Secret"] = clientSecret
//        val responseBody = ApiExamSearchBlog[apiURL, requestHeaders]
//        println(responseBody)
//    }
//
//    private operator fun get(apiUrl: String, requestHeaders: Map<String, String>): String {
//        val con: HttpURLConnection = connect(apiUrl)
//        return try {
//            con.setRequestMethod("GET")
//            for ((key, value) in requestHeaders) {
//                con.setRequestProperty(key, value)
//            }
//            val responseCode: Int = con.getResponseCode()
//            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
//                readBody(con.getInputStream())
//            } else { // 에러 발생
//                readBody(con.getErrorStream())
//            }
//        } catch (e: IOException) {
//            throw RuntimeException("API 요청과 응답 실패", e)
//        } finally {
//            con.disconnect()
//        }
//    }
//
//    private fun connect(apiUrl: String): HttpURLConnection {
//        return try {
//            val url = URL(apiUrl)
//            url.openConnection() as HttpURLConnection
//        } catch (e: MalformedURLException) {
//            throw RuntimeException("API URL이 잘못되었습니다. : $apiUrl", e)
//        } catch (e: IOException) {
//            throw RuntimeException("연결이 실패했습니다. : $apiUrl", e)
//        }
//    }
//
//    private fun readBody(body: InputStream): String {
//        val streamReader = InputStreamReader(body)
//        try {
//            BufferedReader(streamReader).use { lineReader ->
//                val responseBody = StringBuilder()
//                var line: String?
//                while (lineReader.readLine().also { line = it } != null) {
//                    responseBody.append(line)
//                }
//                return responseBody.toString()
//            }
//        } catch (e: IOException) {
//            throw RuntimeException("API 응답을 읽는데 실패했습니다.", e)
//        }
//    }

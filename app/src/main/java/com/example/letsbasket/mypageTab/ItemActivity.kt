package com.example.letsbasket.mypageTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.letsbasket.R
import com.example.letsbasket.itemDetail.LikeResponse
import com.example.letsbasket.itemDetail.IPostRequest
import com.example.letsbasket.itemDetail.SingleItem
import com.example.letsbasket.network.*
import kotlinx.android.synthetic.main.activity_item_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_post)


        val auth =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiY2hvZW5naGEifSwiaWF0IjoxNjI5OTAwMzMxLCJleHAiOjM2MDAxNjI5OTAwMzMxfQ.SE2FTfk8NeJt7UAzTM1pVuH1fdapxVCxxxxRcizY2QE"
        val postID = "612640f4c16520735cd7b041"
        //val postID = "610bff760684e00fb8cec43f"
        val postID_json: IPostRequest = IPostRequest(postID)

        val callGetItem = RetrofitClass.apiPostDetail.getItem(auth, postID)
        val callAddLike = RetrofitClass.apiPostDetail.addLike(auth, postID_json)
        val callDeleteLike = RetrofitClass.apiPostDetail.deleteLike(auth, postID)
        val callParticipateDeal = RetrofitClass.apiPostDetail.addRoom(auth, postID_json)

        // 게시글(상품) 정보 가져오기
        callGetItem.enqueue(object : Callback<SingleItem> {
            override fun onResponse(call: Call<SingleItem>, response: Response<SingleItem>) {
                if (response.isSuccessful) { // <--> response.code == 200
                    // 성공 처리

                    //ex)
                    //Toast.makeText(this, "${response.body().student.size}", Toast.LENGTH_SHORT).show()

                    //Toast.makeText(this, "${response.body()?.data?.title}", Toast.LENGTH_SHORT).show()
                    //Log.d("결과", "성공 : ${response.raw()}")
                    Log.d("결과", "성공 : ${response.body()}")
                    postTitle.text = response.body()?.data?.title
                    userName.text = response.body()?.data?.openerName.toString()
                    userDong.text = response.body()?.data?.dong.toString()
                    price.text = response.body()?.data?.price.toString() + "원"
                    description.text = response.body()?.data?.desc.toString()
                    var isLike = response.body()?.like

                    if (isLike == false) {
                        likeBtn.setImageResource(R.drawable.like)
                    } else {
                        likeBtn.setImageResource(R.drawable.like_click)
                    }

                    // 좋아요 추가 및 삭제
                    likeBtn.setOnClickListener {
                        if (isLike == false) {
                            callAddLike.enqueue(object : Callback<LikeResponse> {
                                override fun onResponse(
                                    call: Call<LikeResponse>,
                                    response: Response<LikeResponse>
                                ) {
                                    if (response.isSuccessful) {
                                        likeBtn.setImageResource(R.drawable.like_click)
                                        Toast.makeText(
                                            this@ItemActivity,
                                            "좋아요에 추가되었습니다.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.d("결과", "성공 : ${response.body()?.msg}")
                                        isLike = true
                                    }
                                }

                                override fun onFailure(call: Call<LikeResponse>, t: Throwable) {
                                    // 실패 처리
                                    Log.d("결과:", "실패 : $t")
                                }
                            })
                        } else {
                            callDeleteLike.enqueue(object : Callback<LikeResponse> {
                                override fun onResponse(
                                    call: Call<LikeResponse>,
                                    response: Response<LikeResponse>
                                ) {
                                    if (response.isSuccessful) {
                                        likeBtn.setImageResource(R.drawable.like)
                                        Toast.makeText(
                                            this@ItemActivity,
                                            "좋아요에서 삭제되었습니다.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.d("결과", "성공 : ${response.body()?.msg}")
                                        isLike = false
                                    }
                                }

                                override fun onFailure(call: Call<LikeResponse>, t: Throwable) {
                                    // 실패 처리
                                    Log.d("결과:", "실패 : $t")
                                }
                            })


                        }
                    }

                    // 딜 참여
                    dealBtn.setOnClickListener{
                        callParticipateDeal.enqueue(object : Callback<ParticipateDealResponse> {
                            override fun onResponse(
                                call: Call<ParticipateDealResponse>,
                                response: Response<ParticipateDealResponse>
                            ) {
                                if (response.isSuccessful) {
                                    Toast.makeText(
                                        this@ItemActivity,
                                        "딜에 참여하였습니다.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    Log.d("결과", "성공 : ${response.body()}")
                                }
                            }

                            override fun onFailure(call: Call<ParticipateDealResponse>, t: Throwable) {
                                // 실패 처리
                                Log.d("결과:", "실패 : $t")
                            }
                        })
                    }

                } else { // code == 400
                    // 실패 처리
                    Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<SingleItem>, t: Throwable) { // code == 500
                // 실패 처리
                Log.d("결과:", "실패 : $t")
            }


        })


    }

}



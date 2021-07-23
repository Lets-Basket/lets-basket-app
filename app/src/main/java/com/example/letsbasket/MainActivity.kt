package com.example.letsbasket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.letsbasket.categoryTab.CategoryTab
import com.example.letsbasket.chattingTab.ChatRoomFragment
import com.example.letsbasket.chattingTab.ChattingTab
import com.example.letsbasket.homeTab.HomeTab
import com.example.letsbasket.mypageTab.MypageTab
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //checkPermission()

        mContext = applicationContext
        initViewPager() // 뷰페이저와 어댑터 장착

    }


    private fun createView(tabName: String): View {
        var tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        tabView.tab_text.text = tabName
        when (tabName) {
            "마이 바스켓" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_help)
                return tabView
            }
            "채팅" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_send)
                return tabView
            }
            "카테고리" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_dialog_dialer)
                return tabView
            }
            "홈" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_input_get)
                return tabView
            }
            else -> {
                return tabView
            }
        }
    }
    private fun initViewPager(){
        val mypageFragment = MypageTab()
        mypageFragment.name = "마이페이지"

        val chattingFragment = ChatRoomFragment()
        //chattingFragment.name = "채팅"

        val categoryFragment = CategoryTab()
        categoryFragment.name = "카테고리"

        val homeFragment = HomeTab()
        homeFragment.name = "홈"



        val adapter = PageAdapter(supportFragmentManager) // PageAdapter 생성
        adapter.addItems(homeFragment)
        adapter.addItems(categoryFragment)
        adapter.addItems(chattingFragment)
        adapter.addItems(mypageFragment)


        main_viewPager.adapter = adapter // 뷰페이저에 adapter 장착
        main_tablayout.setupWithViewPager(main_viewPager) // 탭레이아웃과 뷰페이저를 연동


        main_tablayout.getTabAt(0)?.setCustomView(createView("홈"))
        main_tablayout.getTabAt(1)?.setCustomView(createView("카테고리"))
        main_tablayout.getTabAt(2)?.setCustomView(createView("채팅"))
        main_tablayout.getTabAt(3)?.setCustomView(createView("마이 바스켓"))

//        main_tablayout.getTabAt(2)?.setOnClickListener {
//            val intent = Intent(this.activity, MemoAddActivity::class.java)
//            intent.putExtra(MemoConstant.MEMO_REQUEST_TYPE_KEY, MemoConstant.MEMO_ADD_REQUEST_TYPE)
//            activity?.startActivity(intent)
//        }

//        main_tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabReselected(p0: TabLayout.Tab?) {}
//
//            override fun onTabUnselected(p0: TabLayout.Tab?) {}
//
//            override fun onTabSelected(p0: TabLayout.Tab?) {}
//        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        for(fragment in supportFragmentManager.fragments){
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

//    fun checkPermission() {
//        // 1. 위험권한(Camera) 권한 승인상태 가져오기
//        val permissions = arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS,
//                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        val premissionInRequest: MutableList<String> = mutableListOf()
//
//        for(permission in permissions){
//            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
//                premissionInRequest.add(permission)
//            }
//        }
//
//        if(premissionInRequest.isNotEmpty()){
//            requestPermission(premissionInRequest.toTypedArray())
//        }
//
//    }
//
//    fun requestPermission(permissions: Array<String>) {
//        // 2. 권한 요청
//        for(permission in permissions){
//            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
//            }
//        }
//
//        ActivityCompat.requestPermissions( this, permissions, PermissionChecker.MAIN_PERMISSION_REQUEST_CODE)
//    }
//
//    override fun onRequestPermissionsResult(
//            requestCode: Int,
//            permissions: Array<out String>,
//            grantResults: IntArray
//    ) {
//        when(requestCode) {
//            PermissionChecker.MAIN_PERMISSION_REQUEST_CODE -> {
//                for (grantResult in grantResults) {
//                    if (grantResult == PackageManager.PERMISSION_DENIED) {
//                        finish()
//                    }
//                }
//            }
//        }
//    }
}
package com.example.letsbasket.chattingTab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.letsbasket.FragmentTab;
import com.example.letsbasket.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatRoomFragment extends FragmentTab implements View.OnClickListener {
    private static final String TAG = "ChatRoomFragment";
    EditText chatroom_et;
    Button enter_btn;

    public ChatRoomFragment() {
        // Required empty public constructor
    }

    public static ChatRoomFragment newInstance(String param1, String param2) {
        ChatRoomFragment fragment = new ChatRoomFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat_room, container, false);
        enter_btn = rootView.findViewById(R.id.enter_btn);
        enter_btn.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enter_btn:
                if(chatroom_et.getText().toString().trim().length() >= 0){
                    Log.d(TAG, "입장처리");

                    // 원하는 데이터를 담을 객체
                    Bundle argu = new Bundle();
                    argu.putString("chatroom", chatroom_et.getText().toString());

                    // 이동할 Fragment 선언
                    ChatMsgFragment chatMsgFragment = new ChatMsgFragment();

                    // 이동할 Fragment 에 데이터 객체 담기
                    chatMsgFragment.setArguments(argu);

                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                            .replace(R.id.mainFragment, chatMsgFragment, "CHATMSG")
                            .addToBackStack(null)
                            .commit();

                }else
                {
                    Toast.makeText(getActivity(), "채팅방 이름을 입력하세요", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
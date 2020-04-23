package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Logo extends AppCompatActivity {
    Handler handler;
    //5초 후에 처리해야 하는 작업을 쓰레드 정의
    Runnable runnable = new Runnable() { //익명이너클래스로 처리
        @Override
        public void run() {
            Intent intent = new Intent(Logo.this, HandlerExam2.class);
            startActivity(intent);
            finish(); //이동하고 나면 현재 액티비티가 없어져야 한다.
            //메인 액티비티로 전환될 때 애니메이션 효과를 추가할수 있다.
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        handler = new Handler();
        //핸들러에게 postDelayed메소드를 사용해서 의뢰
        handler.postDelayed(runnable, 5000); //5초 뒤
    }
}

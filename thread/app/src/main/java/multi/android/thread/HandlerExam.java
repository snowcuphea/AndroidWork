package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HandlerExam extends AppCompatActivity {

    Handler handler;
    TextView textView;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        textView = findViewById(R.id.textview);

        handler = new Handler(){


            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==1){//메세지를 보낸게 1이면 작업한다.
                    int val = msg.arg1;
                    textView.setText(val+"");
                }
            }
        };

    }
    public void btnHandy(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    //변경할 뷰의 정보나 Handler에게 전달한 데이터를 Message객체로 생성한다.
                    Message msg = new Message();
                    //handler에게 작업을 의뢰한 스레드를 구분하기 위한 코드
                    msg.what = 1;
                    msg.arg1 = i; //전달할 데이터
                    //Message객체를 전달하며 핸들러에게 작업을 의뢰
                    handler.sendMessage(msg);
                    SystemClock.sleep(100); //1초동안 쉬게 (1초동안 멈춰있는 효과)
                }
            }
        }).start();


    }
}

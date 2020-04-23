package multi.android.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerExam2 extends AppCompatActivity {

    Handler handler;
    TextView textView;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        textView = findViewById(R.id.textview);

        // 2) UI쓰레드에서 핸들러 객체 생성
        handler = new Handler();

    }

    public void btnHandy(View view){
        //버튼을 누르면 쓰레드를 start
        new NumThread().start();
    }

    // 3)TextView의 값을 지속적으로 변경하는 쓰레드 생성
    // - 밑에 있는 요청하는 쓰레드를 이용해 UI변경하는 쓰레드
    class UIUpdateThread implements Runnable{

        @Override
        public void run() {
            textView.setText(num+"");
        }
    }

    // 1) 이너클래스 : 지속해서 값을 만드는 쓰레드 생성
    class NumThread extends Thread{
        public void run(){
            for(int i=1;i<=10;i++){
                num=i;
                // worker thread에서 Handler객체에게 작업을 의뢰 - post메소드 사용
                // 핸들러에게 UI를 변경하는 쓰레드를 전달하며 요청

                handler.post(new UIUpdateThread());
                SystemClock.sleep(100);
            }
        }
    }
}

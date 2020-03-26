package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//이벤트 처리할 객체가 한 개인 경우 익명이너클래스를 이용해서 처리
public class AnonymousEventTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_test);
        Button btn = findViewById(R.id.mybtn);

        //이벤트핸들러를 직접 만들 수 있다.
        //익명이너클래스     이너클래스:클래스안의클래스
        // new 인터페이스명()   ==>지정한 인터페이스의 하위 객체를 만들어서
        //setOnClickLinstener의 매개변수로 전달하겠다는 의미
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnonymousEventTest.this, "익명이너클래스",Toast.LENGTH_LONG).show();
        //그냥 this하면 OnClickListener부분이 되어버리니까 외부 클래스를 앞에 언급해준다.
            }
        });
    }
}

package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import exam.day03.view.selectview.R;

public class AddViewTestActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //Layout만들기 - width, height 지정
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        //LayoutParams : LinearLayout이 갖고 있는 이너클래스.
        // 레이아웃 속성들을 적용할 수 있게 한다.

        //Layout에 추가할 view를 생성 - 상위뷰의 크기 정보를 갖고 있는 LayoutParams를 설정
        Button btn = new Button(this);
        btn.setText("코드로 만들어진 버튼");
        btn.setLayoutParams(params); //width, height가 적용된 것으로 set해준다.

        //Layout에 뷰를 추가 : addView 메소드 사용
        layout.addView(btn);

        //Layout을 Activity에 붙이기
        setContentView(layout);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button btn2 = new Button(AddViewTestActivity.this);
                //AddViewTestActivity.this : 나 말고 outter 클래스를 지칭한다는 뜻
                btn2.setText("이벤트로 만들어진 객체");
                layout.addView(btn2);

            }
        });



    }
}

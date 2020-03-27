package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class FrameTextActivity_teacher extends AppCompatActivity {
LinearLayout linear1;
LinearLayout linear2;
LinearLayout linear3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_text_teacher);

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

    }

    //Button이 클릭될 때 호출되ㅡㄴ 메소드 = View.OnClickListener의
    //public void OnClick(View v) 메소드와 동일
    public void myclick(View v){
        if(v.getId()==R.id.loginframe){
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.joinframe){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.detailframe){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.VISIBLE);
        }

    }


}

package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button bt2 = findViewById(R.id.bt2);

        //인텐트 객체 추출
        Intent intentsecond = getIntent();

        //인텐트 객체에서 공유된 값을 꺼내기
        String msg = intentsecond.getStringExtra("info");
        int data = intentsecond.getIntExtra("num",0);

        //값이 잘 공유되었나 토스트로 확인
        Toast.makeText(this,"추출한 값:"+msg+","+data,
                Toast.LENGTH_LONG).show();

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //액티비티 종료
            }
        });
    }
}

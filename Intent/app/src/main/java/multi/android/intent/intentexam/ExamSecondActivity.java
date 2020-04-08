package multi.android.intent.intentexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamSecondActivity extends AppCompatActivity {

    TextView second_result_txt;
    Button second_close_btn;
    CheckBox second_check;
    String checkdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);
       second_result_txt = findViewById(R.id.exam_result_txt);
       second_close_btn = findViewById(R.id.exam_close);
       second_check = findViewById(R.id.member_state);
        final Intent secondintent = getIntent();

       final String namedata = secondintent.getStringExtra("name");
       final String phonedata = secondintent.getStringExtra("phone");


       second_result_txt.setText("입력한id:"+namedata+" 입력한번호:"+phonedata);

       second_close_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               secondintent.putExtra("secondname",namedata);
               secondintent.putExtra("secondphone",phonedata);

               if(second_check.isChecked()){
                   checkdata="우수회원";
               }else{
                   checkdata="";
               }
               secondintent.putExtra("secondcheck",checkdata);

               setResult(RESULT_OK,secondintent);

               finish();
           }
       });


    }
}

package multi.android.intent.intentexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamFirstActivity extends AppCompatActivity {

    EditText nametxt;
    EditText phonetxt;
    Button submitbtn;
    TextView resulttxt;

    public static final int COCO = 915;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);

        nametxt = findViewById(R.id.EditText01);
        phonetxt = findViewById(R.id.EditText02);
        submitbtn = findViewById(R.id.Button01);
        resulttxt = findViewById(R.id.first_return);



        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExamFirstActivity.this,
                        ExamSecondActivity.class);

                intent.putExtra("name",nametxt.getText()+"");
                intent.putExtra("phone",phonetxt.getText()+"");
                startActivityForResult(intent,COCO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==COCO){
            if(resultCode==RESULT_OK){
                String returnname = intent.getStringExtra("secondname");
                String returnphone = intent.getStringExtra("secondphone");
                String returncheck = intent.getStringExtra("secondcheck");

                nametxt.setText(returnname);
                phonetxt.setText(returnphone);
                resulttxt.setText(returncheck);



            }
        }
    }
}

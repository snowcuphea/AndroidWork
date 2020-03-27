package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Text_Exam_chatting extends AppCompatActivity {
    EditText txtinfo;
    TextView chatlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text__exam_chatting);
        chatlist = findViewById(R.id.chatlist);
        txtinfo = findViewById(R.id.inputtext);
        Button submit = findViewById(R.id.btnsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String tmp = txtinfo.getText()+"";
               // String cht = chatlist.getText()+"";
                //채팅리스트에 쌓인 값을 저장한다.

                //chatlist.setText(cht + "\n" + tmp);
                //채팅리스트에 쌓인 값 + 새로 입력으로 들어온 값 저장
                chatlist.append(txtinfo.getText()+"\n");
                txtinfo.setText("");
            }
        });
    }
}

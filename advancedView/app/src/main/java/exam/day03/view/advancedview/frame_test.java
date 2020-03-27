package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class frame_test extends AppCompatActivity {

    LinearLayout login;
    LinearLayout join;
    LinearLayout detail;
    EditText joinname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);
        Button loginbtn = findViewById(R.id.loginframe);
        Button joinbtn = findViewById(R.id.joinframe);
        Button detailbtn = findViewById(R.id.detailframe);
        Button joinsubmit = findViewById(R.id.joinbtn);
        joinname = findViewById(R.id.joinname);

        final TextView namearea = findViewById(R.id.namearea);

        login =  findViewById(R.id.login);
        join =  findViewById(R.id.join);
        detail =  findViewById(R.id.detail);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.VISIBLE);
                join.setVisibility(View.INVISIBLE);
                detail.setVisibility(View.INVISIBLE);
            }
        });

        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.INVISIBLE);
                join.setVisibility(View.VISIBLE);
                detail.setVisibility(View.INVISIBLE);
            }
        });

        detailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.INVISIBLE);
                join.setVisibility(View.INVISIBLE);
                detail.setVisibility(View.VISIBLE);
            }
        });

        joinsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.INVISIBLE);
                join.setVisibility(View.INVISIBLE);
                detail.setVisibility(View.VISIBLE);
                String tmp = joinname.getText()+"";
                namearea.setText(tmp);
            }
        });




    }



}

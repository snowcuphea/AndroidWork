package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import exam.day03.view.selectview.R;

public class InflatorTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflator_test);

        Button btn = findViewById(R.id.btnAdd);
        final LinearLayout container = findViewById(R.id.container);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LayoutInflater myinflator =
                        (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                myinflator.inflate(R.layout.include_view,container,true);
                //inflate(무엇을, 어디에붙일지,true)
            }
        });
    }
}

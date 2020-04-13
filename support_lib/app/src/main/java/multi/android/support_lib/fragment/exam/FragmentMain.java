package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.FirstFragment;
import multi.android.support_lib.fragment.SecondFragment;

public class FragmentMain extends AppCompatActivity {

    FirstFrag firstFrag = new FirstFrag();
    SecondFrag secondFrag = new SecondFrag();
    ThirdFrag thirdFrag = new ThirdFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);
        Button btnFirst = findViewById(R.id.button);
        Button btnSecond = findViewById(R.id.button2);
        Button btnThird = findViewById(R.id.button3);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("third");
            }
        });

    }
    public void setFragment(String name){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (name){
            case  "first":
                transaction.replace(R.id.container,firstFrag); //(교체할부분, 뭐로교체할지)
                break;
            case "second" :
                transaction.remove(firstFrag);
                transaction.replace(R.id.container,secondFrag);

                break;
            case "third":
                transaction.remove(firstFrag);
                transaction.replace(R.id.container,thirdFrag);
        }

        transaction.commit();

    }

}

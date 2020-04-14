package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.FirstFragment;
import multi.android.support_lib.fragment.SecondFragment;

public class ViewFragment extends AppCompatActivity {

    FirstFrag firstFrag = new FirstFrag();
    SecondFrag secondFrag = new SecondFrag();
    ThirdFrag thirdFrag = new ThirdFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);
        Button btnFirst = findViewById(R.id.button);
        Button btnSecond = findViewById(R.id.button2);
        Button btnThird = findViewById(R.id.button3);

       /* btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(v.getTag().toString());
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(v.getTag().toString());
            }
        });
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(v.getTag().toString());
            }
        });*/
    }

    public void btn_click(View v){
        setFragment(v.getTag().toString());
    }
    public void setFragment(String idx){

        FragmentManager fragmentManager = getSupportFragmentManager();

        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (idx){
            case  "0":
                transaction.replace(R.id.container,firstFrag); //(교체할부분, 뭐로교체할지)
                break;
            case "1" :
                transaction.replace(R.id.container,secondFrag);

                break;
            case "2":
                transaction.replace(R.id.container,thirdFrag);
        }

        transaction.commit();

    }

}

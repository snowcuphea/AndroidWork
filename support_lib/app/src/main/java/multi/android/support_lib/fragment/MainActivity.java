package multi.android.support_lib.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;


public class MainActivity extends AppCompatActivity {
    //화면에 연결한 프래그먼트 객체를 생성한다.
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFirst = findViewById(R.id.btnAddFrag);
        Button btnRemove = findViewById(R.id.btnRemoveFrag);
        Button btnSecond = findViewById(R.id.btnSecondFrag);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("remove");
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });

    }
    //구분해놓은 영역에 fragment를 교체해서 보여줄 메소드
    public void setFragment(String name){
        //fragment객체를 관리하는 관리자객체를 구한다.
        FragmentManager fragmentManager = getSupportFragmentManager();

        //fragment작업을 시작하기 위한 트랜잭션 객체를 구한다.
        //트랜잭션 : 작업. 작업의 단위
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (name){
            case  "first":
                //지정한 fragmnet로 특정영역을 교체하는 작업
                transaction.replace(R.id.container,firstFragment); //(교체할부분, 뭐로교체할지)
                break;
            case "remove" :
                //firstFrament를 안 보이도록
                //detach()을 한 번 사용하면 replace를 못함
                transaction.remove(firstFragment);
                break;
            case "second":
                transaction.replace(R.id.container,secondFragment);

        }
        //transaction.commitNow(); //지금 당장 처리해달라고 요청
        transaction.commit(); //스케쥴 고려해서 적당한 시기에 변경해달라고 요청
        //보통 commit을 많이 씀

    }
  
}

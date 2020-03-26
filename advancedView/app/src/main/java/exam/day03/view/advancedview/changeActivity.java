package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class changeActivity extends AppCompatActivity {

    ImageView img01;
    ImageView img02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_exam);
        img01 =  findViewById(R.id.img01);
        img02 =  findViewById(R.id.img02);
    }

    //버튼이 클릭될 때 호출되는 메소드.
    //클릭할 때 어떤 뷰가 선택되는지, 뷰를 전달해주어야 한다.(View v)
    public void upclick(View v){
        imageSwitchup();
    }
    public void bottomclick(View v){
        imageSwitchdown();
    }
    //버튼을 선택할 때마다 이미지가 교체되어 보이도록 구현
    public void imageSwitchup(){
            img01.setVisibility(View.VISIBLE);
            img02.setVisibility(View.INVISIBLE);
    }

    public void imageSwitchdown(){
            img01.setVisibility(View.INVISIBLE);
            img02.setVisibility(View.VISIBLE);

    }
}

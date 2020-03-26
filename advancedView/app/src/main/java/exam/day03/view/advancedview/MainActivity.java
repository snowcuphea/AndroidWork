package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.wifi.p2p.WifiP2pConfig;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img01;
    ImageView img02;
    int index; //뭐가 실행중인지(현재 어떤이미지인지) 알기 위한 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img01 =  findViewById(R.id.img01);
        img02 =  findViewById(R.id.img02);
    }

    //버튼이 클릭될 때 호출되는 메소드.
    //클릭할 때 어떤 뷰가 선택되는지, 뷰를 전달해주어야 한다.(View v)
    public void myclick(View v){
        imageChange();
    }

    //버튼을 선택할 때마다 이미지가 교체되어 보이도록 구현
    public void imageChange(){
        if(index==0){
            //0번에 해당하는 이미지를 화면에 보이도록 설정
            img01.setVisibility(View.VISIBLE);
            //1번은 화면에 보이지 않도록 설정
            img02.setVisibility(View.INVISIBLE);
            Log.d("value","현재index값==>"+index);
            index=1; //1로 바꿔줘야 다음이 실행되므로
        }else if(index==1){
            img01.setVisibility(View.INVISIBLE);
            img02.setVisibility(View.VISIBLE);
            Log.d("value","현재index값==>"+index);
            index=0;
        }

    }
}

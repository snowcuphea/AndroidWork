package exam.day03.view.advancedview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);

        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        btn1 = findViewById(R.id.seekBtn1);
        btn2 = findViewById(R.id.seekBtn2);
        btn3 = findViewById(R.id.seekBtn3);
        btn4 = findViewById(R.id.seekBtn4);

        //리스너연결 - 이벤트연결(위젯이 이벤트에 반응할 수 있도록 연결)
        //반드시 들어가야 한다.//그래야 위젯들이 이벤트가 발생했을 때 반응하게 만들어 줄 수 있다.
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        //리스너를 위에서 implements했기 때문에 this로 해주면된다.

       // SeekBarListener listener = new SeekBarListener();
    }
    //버튼을 클릭할 때 자동으로 호출되는 메소드
    //View : 매개변수로 전달되는 View가 이벤트를 발생시키는 소스객체
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seekBtn1: //getId한 것이 seekBtn1일 경우
                seek1.incrementProgressBy(1); //값을 1증가시킨다.
                seek2.incrementProgressBy(1);
                //seekbar는 progressbar 종류라서 함수가 같다.
                break;
            case R.id.seekBtn2:
                seek1.incrementProgressBy(-1);
                seek2.incrementProgressBy(-1);
                break;
            case R.id.seekBtn3:
                seek1.setProgress(5);
                seek2.setProgress(7);
                break;
            case R.id.seekBtn4:
                //값을 가져오기
                int value1 = seek1.getProgress();
                text1.setText("seek1의 값: "+value1);
                text2.setText(seek2.getProgress()+"");
                //getProgress는 int형인데(모든 변수는 int형으로 저장됨)
                //setText에 String이 와야하므로, 억지로 String으로 변환해준다.
                break;
        }
    }

    //SeekBar의 값이 변경되었을 때 호출되는 메소드
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //매개변수로 전달되는 값을 잘 보자
        // 현재 progress 값과, Boolean 타입의 fromUser 가 전달된다.
        int id = seekBar.getId();

        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째 seekbar:"+progress);
                break;
            case R.id.seekBar2:
                text1.setText("두 번째 seekbar:"+progress);
                break;
        }
        if(fromUser){
            text2.setText("사용자가 변경");
        }else{
            text2.setText("코드로 변경");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();

        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째 SeekBar를 터치 시작");
                break;
            case R.id.seekBar2:
                text1.setText("두 번째 SeekBar를 터치 시작");
                break;
        }
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();

        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째 SeekBar 터치 종료 ");
                break;
            case R.id.seekBar2:
                text1.setText("두 번째 SeekBar 터치 종료 ");
                break;
        }
    }
}










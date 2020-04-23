package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskExam extends AppCompatActivity {
    TextView textView;
    Button button1;
    Button button2;
    ProgressBar progressBar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);

        AsynTestExam asynTestExam = new AsynTestExam();
        asynTestExam.execute(R.drawable.d1,R.drawable.d2);
    }

    public void btn_first(View view){

        //쓰레드 실행 문장 넣기
        //.start()

    }

    public void btn_second(View view){

    }

    class AsynTestExam extends AsyncTask<Integer,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync","onPreExecute호출! ..작업 시작..");

        }

        @Override
        protected String doInBackground(Integer... integers) {
            int num1 = integers[0]; //2개 지정했으니 첫 번째 값
            int num2 = integers[1];
            int img;

            for(int i=1; i<=100 ; i++) {
                //if (cancelled == true){ break;
            //}
                SystemClock.sleep(100);
                if(i%2==0){
                    img = num1;
                }else{
                    img = num2;
                }

                int result = i;
                publishProgress(result, img);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0]);
            imageView.setImageResource(values[1]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }
}

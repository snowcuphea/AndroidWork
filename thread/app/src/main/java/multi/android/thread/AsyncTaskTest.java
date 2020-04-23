package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        view1 = findViewById(R.id.txtView1);
        view2 = findViewById(R.id.txtView2);

        AsynTestExam asynTestExam = new AsynTestExam();
        //매개변수를 정의하면 매개변수가 doInBackground를 호출할 때 전달됨
        asynTestExam.execute(10,20);
        //매개변수 가변형이라 개수를 원하는 대로 적는다.
        //안드로이드에서의 쓰레드는 AsyncTask를 상속받는 것이다.
        //execute의 매개변수는 AsyncTask<Integer,Long,String>에서 Integer에 해당된다.

    }
    public void btn_click(View view){
        long now_time = System.currentTimeMillis();
		view1.setText(now_time+"");
    }

    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    class AsynTestExam extends AsyncTask<Integer,Long,String>{
        //타입이 없는 경우 Void로 주면 된다.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync","onPreExecute호출! ..작업 시작..");
        }
        @Override
        protected String doInBackground(Integer... integers) {
            //백그라운드에서 처리할 일을 명시. 매개변수가 가변형!
            int num1 = integers[0]; //2개 지정했으니 첫 번째 값
            int num2 = integers[1];
            for(int i=1; i<=10 ; i++){
                SystemClock.sleep(1000);
                Log.d("myasync","i="+i+"num1="+num1+",num2="+num2);
                long now_time = System.currentTimeMillis();
                publishProgress(now_time);
            }
            return "모든 처리 작업이 완료";
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            //doInBackgroubnd에서 발생하는 값을 이용해서 화면을 변경하고 싶은 경우
            view2.setText("Async테스트:"+values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        //다 끝내고 마지막으로 할 작업을 명시
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            view1.setText("반환값:"+s);
        }
    }
   
}

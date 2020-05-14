package multi.android.network.arduino;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import multi.android.network.R;

public class LedControlActivity extends AppCompatActivity {
    AsyncTaskExam asyncTaskExam;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;
    Socket socket;
    OutputStream os;
    PrintWriter pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_control);
        asyncTaskExam = new AsyncTaskExam();
        asyncTaskExam.execute(10,20); //지금은 넘겨주는 값이 없어서 void로 해줘도 된다.
    }
    public void send_msg(final View view){
        //보내는 값 쓰레드로 만들어줘야 한다.
        new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                if(view.getId()==R.id.btn_led_on){
                    message = "led_on";
                }else{
                    message = "led_off";
                }
                pw.println(message);
                pw.flush();
            }
        }).start();
       
    }
    class AsyncTaskExam extends AsyncTask<Integer,String,String> {
        @Override
        protected String doInBackground(Integer... integers) {
            try {
                socket = new Socket("70.12.224.220", 12345);
                if (socket != null) {
                    ioWork();
                }
                //서버에서 전달하는 메세지를 읽는 쓰레드
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String msg;
                            try {
                                msg = br.readLine();
                                Log.d("chat", "서버로 부터 수신된 메시지>>"
                                        + msg);
                            } catch (IOException e) {
                            }
                        }
                    }
                });
                t1.start();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
         void ioWork(){
            try {
                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                os = socket.getOutputStream();
                pw = new PrintWriter(os,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //소켓은 액티비티가꺼지면 닫아줘야 한다.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

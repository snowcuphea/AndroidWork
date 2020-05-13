package multi.android.network.arduino;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import multi.android.network.R;

public class SerialCommunication extends AppCompatActivity {

    Button turnOnBtn;
    Button turnOffBtn;
    OutputStream out;
    PrintWriter pw;
    Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_communication);
        turnOnBtn = findViewById(R.id.Button_on);
        turnOffBtn = findViewById(R.id.Button_off);

       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   socket = new Socket("70.12.224.220",5000);
                   if(socket!=null){
                       try {
                           out = socket.getOutputStream();
                           pw = new PrintWriter(out, true);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }).start();

        turnOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pw.println(1);
                       // pw.flush();
                    }
                }).start();
            }


        });

        turnOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pw.println(0);
                    }
                }).start();

            }
        });
    }

}

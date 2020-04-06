package exam.day03.view.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends ListActivity {
    //전체 하나의 뷰를 사용하도록 ListActivty를 상속
    //두 줄 텍스트로 리스트뷰를 구성하기

    //HashMap으로 Key와 Value가 같이 들어가야 한다.
    //이런 형태가 여러 개 와야 하기때문에, ArrayList에 저장한다.
    ArrayList<HashMap<String,String>> listdata = new ArrayList<HashMap<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //리스트를 구성할 샘플 데이터 준비
        HashMap<String,String> item = new HashMap<String,String>();
        item.put("name","김민정"); //key, value를 넣어준다.
        item.put("telNum","010-1234-5678");
        listdata.add(item);

        item = new HashMap<String,String>();
        item.put("name","김김김"); //key, value를 넣어준다.
        item.put("telNum","010-1111-2222");
        listdata.add(item);

        item = new HashMap<String,String>();
        item.put("name","민민민"); //key, value를 넣어준다.
        item.put("telNum","010-3333-4444");
        listdata.add(item);

        item = new HashMap<String,String>();
        item.put("name","정정정"); //key, value를 넣어준다.
        item.put("telNum","010-5555-6666");
        listdata.add(item);

        item = new HashMap<String,String>();
        item.put("name","민정"); //key, value를 넣어준다.
        item.put("telNum","010-7777-8888");
        listdata.add(item);

        //데이터를 주면 adapter가 받아서 알아서 listView를 짜주는 것.
        SimpleAdapter mysimpleadapter = new SimpleAdapter(this,
                listdata, //HashMap으로 구성된 데이터가 저장된 리스트
                android.R.layout.simple_list_item_2, //row의 디자인
                //item이 2개니까 simple_list_item_2사용

                new String[]{"name","telNum"}, //HashMap에 저장된 키 리스트
                //위에서 정의한 맵 데이터를 어떤 view에 출력할 것인지

                new int[]{android.R.id.text1,android.R.id.text2}  );
                //키의 순서와 동일한 리소스 아이디 순서

        setListAdapter(mysimpleadapter);



    }
}

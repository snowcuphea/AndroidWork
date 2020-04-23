package multi.android.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.rlist);
        CafeItem item;
        List<CafeItem> recycler_simple_data = new ArrayList<CafeItem>();

        CafeItem item1 = new CafeItem(R.drawable.gong, "무적카페");
        recycler_simple_data.add(item1);
        CafeItem item2 = new CafeItem(R.drawable.jang,"무적카페");
        recycler_simple_data.add(item2);
        CafeItem item3 = new CafeItem(R.drawable.jung,"무적카페");
        recycler_simple_data.add(item3);
        CafeItem item4 = new CafeItem(R.drawable.lee,"무적카페");
        recycler_simple_data.add(item4);
        CafeItem item5 = new CafeItem(R.drawable.so,"무적카페");
        recycler_simple_data.add(item5);

        CafeAdapter myadapter = new CafeAdapter(this,
                R.layout.mycafe_item,
                recycler_simple_data);

        //리니어레이아웃을 세팅할 수 있는 LinearlayoutManager객체
        //그리드를 만드는 레이아웃 매니저 객체도 따로 있다. 종류에 따라 매니저 객체가 존재한다.


        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        list.setHasFixedSize(true);


        list.setLayoutManager(manager); //리사이클러뷰에 VERTICAL LinearLayout이 세팅




        list.setAdapter(myadapter);
    }
}

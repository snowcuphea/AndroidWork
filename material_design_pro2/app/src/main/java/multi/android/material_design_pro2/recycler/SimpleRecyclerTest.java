package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class SimpleRecyclerTest extends AppCompatActivity {
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_test);
        list = findViewById(R.id.rlist);
        //1. Recycler에 출력할 데이터 준비
        List<SimpleItem> recycler_simple_data = new ArrayList<SimpleItem>();
        for(int i=0;i<10;i++){
            SimpleItem item = new SimpleItem("simple_item"+i);
            recycler_simple_data.add(item); //0부터9까지 데이터를 리스트에 추가
        }
        //2. Adapter생성  //SimpleItemAdapter(context, design,data)
        SimpleItemAdapter myadapter = new SimpleItemAdapter(this,
                R.layout.simple_item,
                recycler_simple_data);

        //3. Recycler에 레이아웃을 설정 -  LinearLayout, GridLayout등등
        //   RecyclerView에 설정할 레이아웃객체 생성
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        //리니어레이아웃을 세팅할 수 있는 LinearlayoutManager객체
        //그리드를 만드는 레이아웃 매니저 객체도 따로 있다. 종류에 따라 매니저 객체가 존재한다.
        manager.setOrientation(LinearLayoutManager.VERTICAL);

       /* //GridLayout설정
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        //spanCount : 열로 2 줄 출력하겠다는 의미*/
        list.setHasFixedSize(true);

        list.setLayoutManager(manager); //리사이클러뷰에 VERTICAL LinearLayout이 세팅

        //4. Recycler와 adapter를 연결
        list.setAdapter(myadapter);
        //5. 추가적인 요소들을 적용할 수 있다. - 꾸미기, 애니메이션
    }

}


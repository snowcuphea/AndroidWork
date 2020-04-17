package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardRecTest extends AppCompatActivity {

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_rec_test);
        list = findViewById(R.id.rlist);
        CardItem item;
        List<CardItem> recycler_simple_data = new ArrayList<CardItem>();

        item = new CardItem(R.drawable.lee,"이민호의 신의");
        recycler_simple_data.add(item);
        item = new CardItem(R.drawable.gong,"도깨비의 공유");
        recycler_simple_data.add(item);
        item = new CardItem(R.drawable.so,"미안하다의 소지섭");
        recycler_simple_data.add(item);

        RecyclerCardAdapter myadapter = new RecyclerCardAdapter(this,
                R.layout.card_item,recycler_simple_data);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);
        list.setAdapter(myadapter);
    }
}

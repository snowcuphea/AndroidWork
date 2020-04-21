package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {

    RecyclerView list;
    RecyclerView last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        list = findViewById(R.id.rlist);
        last = findViewById(R.id.rrlist);
        CircleItem item;
        List<CircleItem> recycler_simple_data = new ArrayList<CircleItem>();

        item = new CircleItem(R.drawable.gong);
        recycler_simple_data.add(item);
        item = new CircleItem(R.drawable.jang);
        recycler_simple_data.add(item);
        item = new CircleItem(R.drawable.jung);
        recycler_simple_data.add(item);
        item = new CircleItem(R.drawable.lee);
        recycler_simple_data.add(item);
        item = new CircleItem(R.drawable.so);
        recycler_simple_data.add(item);

        RecyclerCircleAdapter myadapter = new RecyclerCircleAdapter(this,
                R.layout.circle_item,
                recycler_simple_data);

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        list.setHasFixedSize(true);

        list.setLayoutManager(manager);

        list.setAdapter(myadapter);

        last.setHasFixedSize(true);

        last.setLayoutManager(manager);

        last.setAdapter(myadapter);



    }

}

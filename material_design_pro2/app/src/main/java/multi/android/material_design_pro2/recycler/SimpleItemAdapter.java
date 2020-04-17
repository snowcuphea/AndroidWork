package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import multi.android.material_design_pro2.R;

//RecyclerView에서 사용하는 Adpater를 커스터마이징
//Adpter안에 ViewHolder포함 - 정의(ListView사용할 때와 동일한 역할)
//          ----------> 일단 inner Class로 정의

//리스트뷰에서는 getView에서 작업을 한꺼번에 다 했었는데, 여기서는 세 개의 메소드로 나뉜다.
public class SimpleItemAdapter extends RecyclerView.Adapter<SimpleItemAdapter.ViewHolder>{
    //밑에 ViewHolder클래스를 정의해야 .ViewHolder라고 쓸 수 있다.

    Context context; //액티비티
    int row_res_id; //row를 구성하는 layout
    List<SimpleItem> data; //RecyclerView에 출력될 전체 데이터

    public SimpleItemAdapter(Context context, int row_res_id, List<SimpleItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    //xml로 부터 뷰(한 row에 대한 뷰)를 만들어서 ViewHolder 넘기는 작업
    //ViewHolder는 View를 구성하는 구성요소의 리소스를 가져오는 작업을 하는 객체
    //1. onCreateViewHolder에서 row에 대한 뷰를 inflate해서 생성
    //2. ViewHolder객체를 만들어서 1번에서 생성한 뷰를 넘긴다.
    //3. ViewHolder객체 안에서 onCreateViewHolder메소드에서리턴받은 객체에서
    //   데이터를 연결할 뷰를 찾아온다.
    //4. onBindViewHolder메소드에서 ViewHolder가 갖고 있는 구성요소에 데이터를 연결하기
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
                //inflate를 바로 못쓰니까 from메소드를 통해 inflate를 호출한다.
        return new ViewHolder(view);
        //생성자한테 view를 넘긴다.
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("recycler","onBindViewHolder:"+position);//순서출력
        //ViewHolder가 찾아놓은 TextView를 꺼내고
        TextView row_text_view = holder.textview;
        //꺼낸 TextView에 데이터 연결
        row_text_view.setText(data.get(position).getData());
        //TextView에 클릭이벤트 연결
        row_text_view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context,"데이터연결완료",Toast.LENGTH_LONG).show();
            }
        });

    }
    //RecyclerView에 출력할 데이터의 갯수
    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textview; //layoutinflater에 있는 것

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.itemview);
                    //itemView로부터 찾아온다.
        }
    }
}
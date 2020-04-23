package multi.android.cafeorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> {
    Context context;
    int row_res_id;

    List<CafeItem> data;

    public CafeAdapter(Context context, int row_res_id, List<CafeItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView row_image_view = holder.imgview;
        TextView row_text_view = holder.txtview;
        row_image_view.setImageResource(data.get(position).getcafeimg());
        row_text_view.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgview; //layoutinflater에 있는 것
        TextView txtview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imageView);
            txtview = itemView.findViewById(R.id.textView);
            //itemView로부터 찾아온다.
        }
    }




}

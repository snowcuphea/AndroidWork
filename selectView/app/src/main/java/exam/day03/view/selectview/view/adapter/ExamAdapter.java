package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exam.day03.view.selectview.R;

public class ExamAdapter extends ArrayAdapter<ActorItem> {

    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;

    HashMap<Integer,SaveActorState> saveData = new HashMap<Integer, SaveActorState>();


    public ExamAdapter( Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public ActorItem getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null){ //null일 때만 새로 만들어서 작업
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }else {

            holder = (ViewHolder) convertView.getTag();
        }

        ActorItem actorItem = actorlist.get(position); //get position 하면 정보가 찾아진다.

        if(actorItem!=null){
            ImageView imageView = holder.myImg;
            TextView nameView = holder.nameView;
            TextView dateView = holder.dateView;
            TextView commentView = holder.commentView;
            final CheckBox checkView = holder.checkView;


            imageView.setImageResource(actorItem.myImg);
            nameView.setText(actorItem.name);
            dateView.setText(actorItem.date);
            commentView.setText(actorItem.comment);


            SaveActorState state = saveData.get(position);
            if(state!=null){
                checkView.setChecked(false);

            }else{
                checkView.setChecked(true);

            }


            checkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean data = true;
                    SaveActorState objstate = new SaveActorState();
                    objstate.data = data;
                    saveData.put(position,objstate);

                }
            });

        }

        return convertView;
    }
}

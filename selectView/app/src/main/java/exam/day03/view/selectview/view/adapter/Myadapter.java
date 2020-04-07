package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import exam.day03.view.selectview.R;

public class Myadapter extends ArrayAdapter<User> {
    private Context context;
    private int resId;
    private ArrayList<User> datalist;
    //생성자
    public Myadapter(Context context, int resId,  ArrayList<User> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }
    //리스트 갯수를 반환
    @Override
    public int getCount() {
        return super.getCount();
    }
    //매개변수로 전달받은 순서에 있는 리스트 항목을 반환
    @Override
    public User getItem(int position) {
        return super.getItem(position);
    }
    //리스트의 한 항목을 만들때 호출되는 메소드 - 리스트항목이 100개면 100번호출
    //position => 리스트 순서
    //convertView => 한 항목에 대한 뷰
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //컨버트뷰 : 리스트에서 보여지는 로우에 대한 뷰를 리턴해준다.
        // 처음만드는상태면 뷰가 없으므로 null이 나오고, 두번째 부터는 무언가가 있다.
        Log.d("getview","getview"+position);
        long start = System.nanoTime(); //시간측정용
        //뷰를 생성
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Context 특성을 갖고 있어야 getSystemService를 사용할 수 있다.
        //Context는 환경정보를 갖고있기때문에 Activity에서는 그냥 사용이 가능했다.
        //따라서 사용자정의 adapter에서 getSystemService를 사용하려면 context객체를 통해 사용한다.
        convertView = inflater.inflate(resId, null);

        //ArrayList에서 리턴된 리스트 항목의 번호와 동일한 데이터를 구하기
        User user = datalist.get(position); //get position 하면 정보가 찾아진다.


        //위에서 생성한 뷰의 각 요소에 데이터를 연결
        ImageView imageView = convertView.findViewById(R.id.img);
        TextView nameView = convertView.findViewById(R.id.txtcust1);
        TextView telNumView = convertView.findViewById(R.id.txtcust2);


        imageView.setImageResource(user.myImg);
        nameView.setText(user.name);
        telNumView.setText(user.telNum);

        long end = System.nanoTime();
        Log.d("getview",(end-start)+"");

        return convertView;
    }
}

package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import exam.day03.view.selectview.R;
//성능개선을 위한 작업을 추가
// 1. 한 번 만든 뷰는 재사용
// 2. findViewById 한 번 작업한 뷰에 대한 정보는 저장해 놓고 다시 사용

public class Myadapter2 extends ArrayAdapter<User> {
    private Context context;
    private int resId;
    private ArrayList<User> datalist;
    //row마다 사용자가 설정한 값을 position과 함께 저장
    //해당 position에 대한 설정값을 같이 출력
    //저장하는시점은 사용자가 설정을 끝낸 시점 - focus를 잃어버리는 시점
    //position(int)를 같이 저장해야하므로 Hashmap 활용. 상태값
    HashMap<Integer,SaveUserState> saveData = new HashMap<Integer, SaveUserState>();

    public Myadapter2(Context context, int resId, ArrayList<User> datalist) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        //컨버트뷰 : 리스트에서 보여지는 로우에 대한 뷰를 리턴해준다.
        // 처음만드는상태면 뷰가 없으므로 null이 나오고, 두번째 부터는 무언가가 있다.

        Log.d("getview","getview"+position);
        long start = System.nanoTime(); //시간측정용

        //뷰를 생성 - 매개변수로 전달되는 convertView를 재사용
        UserViewHolder holder;
        if(convertView==null){ //null일 때만 새로 만들어서 작업
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            //최초작업이므로 뷰를 찾아서 가져오기
             holder = new UserViewHolder(convertView);
            //홀더를 저장
            convertView.setTag(holder);
        }else {
            //==================뷰를 만드는 최초 작업이 아님 ==================
             holder = (UserViewHolder) convertView.getTag();
        }

        //ArrayList에서 리턴된 리스트 항목의 번호와 동일한 데이터를 구하기
        User user = datalist.get(position); //get position 하면 정보가 찾아진다.
        if(user!=null){
            //위에서 생성한 뷰의 각 요소에 데이터를 연결
            ImageView imageView = holder.myImg;
            TextView nameView = holder.nameView;
            TextView telNumView = holder.telNumView;
            final EditText editView = holder.editView;

            imageView.setImageResource(user.myImg);
            nameView.setText(user.name);
            telNumView.setText(user.telNum);

            //뷰를 만들때 저장된 내용이 있는지 체크해서 값을 출력하기
            SaveUserState state = saveData.get(position);
            if(state==null){//저장된 객체가 없으면
                editView.setText("");
            }else{ //저장된 객체가 있으면 객체에서 data를 추출해서 출력
                editView.setText(state.data);
            }

            //EditText가 focus를 잃어버리는 시점에 입력한 데이터를 저장
            editView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus){
                        String data = editView.getText().toString();
                        SaveUserState objstate = new SaveUserState();
                        objstate.data = data;
                        saveData.put(position,objstate);
                    }
                }
            });
        }
        long end = System.nanoTime();
        Log.d("getview",(end-start)+"");

        return convertView;
    }
}

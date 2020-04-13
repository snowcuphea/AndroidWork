package multi.android.support_lib.fragment.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFrag extends Fragment {

    public SecondFrag() {
        // Required empty public constructor
    }

    //fragment뷰가 만들어질때 호출되는 메소드
    //액티비티에 배치되는 순간 호출되는 메소드 - view를 그리기 위해서 호출하는 메소드
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view2, container, false);
    }
}

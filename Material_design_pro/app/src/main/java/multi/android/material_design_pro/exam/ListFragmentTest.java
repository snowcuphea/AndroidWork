package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragmentTest extends ListFragment {

    public ListFragmentTest() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] data = {"이민호","공유","소지섭","이동욱","박서준","정우성"};
        ArrayAdapter aradapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1,android.R.id.text1,data);
        setListAdapter(aradapter);

    }

}

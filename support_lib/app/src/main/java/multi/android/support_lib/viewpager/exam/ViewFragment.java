package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;

public class ViewFragment extends AppCompatActivity {
    //Fragment들
    FirstFrag viewFragment1 = new FirstFrag();
    //SecondFrag viewFragment2 = new SecondFrag();
    ListFragmentTest viewFragment2 = new ListFragmentTest();
    ThirdFrag viewFragment3 = new ThirdFrag();
    MapFrag viewFragment4 = new MapFrag();

    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragArrayList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);

        fragArrayList.add(viewFragment1);
        fragArrayList.add(viewFragment2);
        fragArrayList.add(viewFragment3);
        fragArrayList.add(viewFragment4);

        FragAdapter myadapter = new FragAdapter(getSupportFragmentManager(),
                fragArrayList.size());
        fragment_viewPager.setAdapter(myadapter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
        //페이지 전환 시 이벤트 보려고 달아준 Listener
    }



    class FragAdapter extends FragmentStatePagerAdapter {
        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            //FragmentManager는 Fragment를 관리하는 애
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragArrayList.size();
        }
    }

    public void btn_click(View v){
        fragment_viewPager.setCurrentItem(Integer.parseInt(v.getTag().toString()));
    }

    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(ViewFragment.this, "페이지가 전환", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}

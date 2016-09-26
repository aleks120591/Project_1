package kr.aleks.project_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

public class ConstrPagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Constr> mConstrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_constr_pager);

        mViewPager = (ViewPager) findViewById(R.id.activity_constr_pager_view_pager);
        mConstrs = ConstrLab.get(this).getConstrs();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Constr constr = mConstrs.get(position);
                return ConstrFragment.newInstance(constr.getId());
            }

            @Override
            public int getCount() {
                return mConstrs.size();
            }
        });
    }
}

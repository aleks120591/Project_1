package kr.aleks.project_1.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

import kr.aleks.project_1.Constr;
import kr.aleks.project_1.ConstrLab;
import kr.aleks.project_1.R;
import kr.aleks.project_1.fragment.ConstrFragment;

public class ConstrPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CONSTR_ID = "kr.aleks.project_1.constr_id";

    private ViewPager mViewPager;
    private List<Constr> mConstrs;

    public static Intent newIntent(Context packageContext, UUID constrId) {
        Intent intent = new Intent(packageContext, ConstrPagerActivity.class);
        intent.putExtra(EXTRA_CONSTR_ID, constrId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_constr_pager);

        UUID constrId = (UUID) getIntent().getSerializableExtra(EXTRA_CONSTR_ID);

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
        for (int i = 0; i < mConstrs.size(); i++) {
            if (mConstrs.get(i).getId().equals(constrId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}

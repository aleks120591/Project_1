package kr.aleks.project_1.activity;

import android.support.v4.app.Fragment;

import kr.aleks.project_1.fragment.ConstrListFragment;
import kr.aleks.project_1.fragment.SingleFragmentActivity;

public class ConstrListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ConstrListFragment();
    }
}

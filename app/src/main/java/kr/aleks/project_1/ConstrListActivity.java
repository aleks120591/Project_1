package kr.aleks.project_1;

import android.support.v4.app.Fragment;

public class ConstrListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new ConstrListFragment();
    }
}

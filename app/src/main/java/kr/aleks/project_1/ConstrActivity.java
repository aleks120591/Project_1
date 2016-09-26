package kr.aleks.project_1;

import android.support.v4.app.Fragment;

public class ConstrActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new ConstrFragment();
    }
}

package kr.aleks.project_1.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

import kr.aleks.project_1.fragment.ConstrFragment;
import kr.aleks.project_1.fragment.SingleFragmentActivity;

public class ConstrActivity extends SingleFragmentActivity {

    private static final String EXTRA_CONSTR_ID = "kr.aleks.project_1.constr_id";

    public static Intent newIntent(Context packageContext, UUID constrId) {
        Intent intent = new Intent(packageContext, ConstrActivity.class);
        intent.putExtra(EXTRA_CONSTR_ID, constrId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID constrId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CONSTR_ID);
        return ConstrFragment.newInstance(constrId);
    }
}

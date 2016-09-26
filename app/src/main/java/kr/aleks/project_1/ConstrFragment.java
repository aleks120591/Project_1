package kr.aleks.project_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConstrFragment extends Fragment {

    private Constr mConstr;
    private ImageView mImageView;
    private TextView mTitleView;
    private TextView mGrowthView;
    private TextView mPlusTheIncreaseView;
    private TextView mTimerView;
    private Button mBuildingButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConstr = new Constr();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_constr, container, false);
        mTitleView = (TextView) v.findViewById(R.id.constr_title);
        mGrowthView = (TextView) v.findViewById(R.id.growth);
        mPlusTheIncreaseView = (TextView) v.findViewById(R.id.plus_the_increase);
        mTimerView = (TextView) v.findViewById(R.id.times_building);
        mBuildingButton = (Button) v.findViewById(R.id.building);
        return v;
    }
}

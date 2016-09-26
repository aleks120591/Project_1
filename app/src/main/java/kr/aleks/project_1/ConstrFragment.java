package kr.aleks.project_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

public class ConstrFragment extends Fragment {

    private static final String ARG_CONSTR_ID = "constr_id";

    private Constr mConstr;
    private ImageView mImageView;
    private TextView mTitleView;
    private TextView mGrowthView;
    private TextView mDescriptionView;
    private TextView mPlusTheIncreaseView;
    private TextView mTimerView;
    private Button mBuildingButton;

    public static ConstrFragment newInstance(UUID constrId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONSTR_ID, constrId);

        ConstrFragment fragment = new ConstrFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID constrId = (UUID) getArguments().getSerializable(ARG_CONSTR_ID);
        mConstr = ConstrLab.get(getActivity()).getConstr(constrId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_constr, container, false);

        mTitleView = (TextView) v.findViewById(R.id.constr_title);
        mTitleView.setText(mConstr.getTitle());

        mImageView = (ImageView) v.findViewById(R.id.constr_image);
        mImageView.setImageResource(mConstr.getImage());

        mGrowthView = (TextView) v.findViewById(R.id.growth);
        mGrowthView.setText(mConstr.getGrowth());

        mDescriptionView=(TextView)v.findViewById(R.id.description);
        mDescriptionView.setText(mConstr.getDescription());

        mPlusTheIncreaseView = (TextView) v.findViewById(R.id.plus_the_increase);

        mTimerView = (TextView) v.findViewById(R.id.times_building);

        mBuildingButton = (Button) v.findViewById(R.id.building);

        return v;
    }
}

package kr.aleks.project_1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.aleks.project_1.Constr;
import kr.aleks.project_1.ConstrLab;
import kr.aleks.project_1.activity.ConstrPagerActivity;
import kr.aleks.project_1.R;

public class ConstrListFragment extends Fragment {

    private RecyclerView mConstrRecyclerView;
    private ConstrAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_constr_list, container, false);
        mConstrRecyclerView = (RecyclerView) view.findViewById(R.id.constr_recycler_view);
        mConstrRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ConstrLab constrLab = ConstrLab.get(getActivity());
        List<Constr> constrs = constrLab.getConstrs();

        if (mAdapter == null) {
            mAdapter = new ConstrAdapter(constrs);
            mConstrRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ConstrHolder extends ViewHolder implements OnClickListener {

        public TextView mTitleTextView;
        public ImageView mImageView;

        private Constr mConstr;

        public ConstrHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_constr_title);
            mImageView = (ImageView) itemView.findViewById(R.id.list_item_constr_image);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_constr_title);
        }

        public void bindConstr(Constr constr) {
            mConstr = constr;
            mTitleTextView.setText(mConstr.getTitle());
            mImageView.setImageResource(mConstr.getImage());
        }

        @Override
        public void onClick(View view) {
            Intent intent = ConstrPagerActivity.newIntent(getActivity(), mConstr.getId());
            startActivity(intent);
        }
    }

    private class ConstrAdapter extends Adapter<ConstrHolder> {

        private List<Constr> mConstrs;

        public ConstrAdapter(List<Constr> constrs) {
            mConstrs = constrs;
        }

        @Override
        public ConstrHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_constr, parent, false);

            return new ConstrHolder(view);
        }

        @Override
        public void onBindViewHolder(ConstrHolder holder, int position) {
            Constr constr = mConstrs.get(position);
            holder.bindConstr(constr);
        }

        @Override
        public int getItemCount() {
            return mConstrs.size();
        }
    }
}
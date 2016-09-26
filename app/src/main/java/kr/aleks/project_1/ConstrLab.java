package kr.aleks.project_1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConstrLab {

    private static ConstrLab sConstrLab;

    private List<Constr> mConstrs;

    public static ConstrLab get(Context context) {
        if (sConstrLab == null) {
            sConstrLab = new ConstrLab(context);
        }
        return sConstrLab;
    }

    private ConstrLab(Context context) {
        mConstrs = new ArrayList<>();

        for (int i = 0; i < Constants.TITLES.length; i++) {
            Constr constr = new Constr();
            constr.setTitle(Constants.TITLES[i]);
            constr.setImage(Constants.IMAGES[i]);
            mConstrs.add(constr);
        }
    }

    public List<Constr> getConstrs() {
        return mConstrs;
    }

    public Constr getConstr(UUID id) {
        for (Constr constr : mConstrs) {
            if (constr.getId().equals(id)) {
                return constr;
            }
        }
        return null;
    }
}

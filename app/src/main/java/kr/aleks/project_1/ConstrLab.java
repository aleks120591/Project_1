package kr.aleks.project_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kr.aleks.project_1.database.ConstrDbSchema.ConstrTable;

public class ConstrLab {

    private static ConstrLab sConstrLab;

    private List<Constr> mConstrs;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ConstrLab get(Context context) {
        if (sConstrLab == null) {
            sConstrLab = new ConstrLab(context);
        }
        return sConstrLab;
    }

    private ConstrLab(Context context) {
        /*mContext = context.getApplicationContext();
        mDatabase = new ConstrBaseHelper(mContext)
                .getWritableDatabase();*/
        mConstrs = new ArrayList<>();

        for (int i = 0; i < Constants.TITLES.length; i++) {
            Constr constr = new Constr();
            constr.setTitle(Constants.TITLES[i]);
            constr.setImage(Constants.IMAGES[i]);
            constr.setDescription(Constants.DESCRIPTION[i]);
            constr.setGrowth(Constants.GROWTH[i]);
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

    private static ContentValues getContentValues(Constr constr) {
        ContentValues values = new ContentValues();
        values.put(ConstrTable.Cols.UUID, constr.getId().toString());
        values.put(ConstrTable.Cols.TITLE, constr.getTitle().toString());
        values.put(ConstrTable.Cols.GROWTH, constr.getGrowth().toString());
        values.put(ConstrTable.Cols.DESCRIPTION, constr.getDescription().toString());
        values.put(ConstrTable.Cols.PLUS_THE_INCREASE, constr.getPlusTheIncrease().toString());
        values.put(ConstrTable.Cols.TITLE, constr.getTimer().toString());
        return values;
    }
}

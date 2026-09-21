/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseDataEntities
extends Vector<BaseDataEntity> {
    private static final long serialVersionUID = -6002618898839162833L;

    public JSONArray ToJSONArray(boolean bIncludeEmpty) {
        Vector<JSONObject> arr = new Vector<JSONObject>();
        for (BaseDataEntity dataEntity : this) {
            JSONObject jsonObject = new JSONObject();
            dataEntity.FillJSONObject(jsonObject, bIncludeEmpty);
            arr.add(jsonObject);
        }
        return JSONArray.fromArray((Object[])arr.toArray());
    }

    @Override
    public synchronized Object clone() {
        BaseDataEntities dataEntities = new BaseDataEntities();
        for (BaseDataEntity dataEntity : this) {
            BaseDataEntity temp = new BaseDataEntity();
            dataEntity.CopyTo(temp, false);
            dataEntities.add(temp);
        }
        return dataEntities;
    }

    public static BaseDataEntities FromJSONArray(JSONArray jsonArray) {
        BaseDataEntities dataEntities = new BaseDataEntities();
        int i = 0;
        while (i < jsonArray.length()) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            BaseDataEntity dataEntity = BaseDataEntity.FromJSONObject(jsonobject);
            dataEntities.add(dataEntity);
            ++i;
        }
        return dataEntities;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.data;

import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataObjectList
extends ArrayList<IDataObject> {
    private static final Log log = LogFactory.getLog(DataObjectList.class);

    public static DataObjectList fromJSONArray(JSONArray jsonArray) throws Exception {
        DataObjectList dataObjects = new DataObjectList();
        int i = 0;
        while (i < jsonArray.length()) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            IDataObject iDataObject = DataObject.fromJSONObject(jsonobject);
            dataObjects.add(iDataObject);
            ++i;
        }
        return dataObjects;
    }

    public JSONArray toJSONArray(boolean bIncludeEmpty) throws Exception {
        Vector<JSONObject> arr = new Vector<JSONObject>();
        for (IDataObject dataEntity : this) {
            JSONObject jsonObject = new JSONObject();
            dataEntity.fillJSONObject(jsonObject, bIncludeEmpty);
            arr.add(jsonObject);
        }
        return JSONArray.fromArray((Object[])arr.toArray());
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.ibizsys.paas.ctrlmodel.GridModelBase;
import net.ibizsys.paas.ctrlmodel.ITreeGridModel;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

public abstract class TreeGridModelBase
extends GridModelBase
implements ITreeGridModel {
    private String strParentDEField = "";

    @Override
    public String getControlType() {
        return "TREEGRID";
    }

    public static void fillHierarchyDatas(ArrayList<JSONObject> list, String strKeyField, String strPKeyField, String strItemsField) throws Exception {
        Object objKey;
        HashMap<Object, JSONObject> entityMap = new HashMap<Object, JSONObject>();
        HashMap<Object, ArrayList<JSONObject>> listMap = new HashMap<Object, ArrayList<JSONObject>>();
        ArrayList<JSONObject> list2 = new ArrayList<JSONObject>();
        for (JSONObject iEntity : list) {
            objKey = iEntity.get(strKeyField);
            entityMap.put(objKey, iEntity);
            Object objPKey = iEntity.opt(strPKeyField);
            if (objPKey == null || objPKey instanceof JSONNull || objPKey.toString().length() == 0) continue;
            ArrayList<JSONObject> list3 = (ArrayList<JSONObject>)listMap.get(objPKey);
            if (list3 == null) {
                list3 = new ArrayList<JSONObject>();
                listMap.put(objPKey, list3);
            }
            list3.add(iEntity);
        }
        for (JSONObject iEntity : list) {
            objKey = iEntity.get(strKeyField);
            ArrayList list3 = (ArrayList)listMap.get(objKey);
            if (list3 != null) {
                iEntity.put(strItemsField, (Collection)list3);
                continue;
            }
            iEntity.put("leaf", true);
        }
        for (JSONObject iEntity : list) {
            Object objPKey = iEntity.opt(strPKeyField);
            if (objPKey != null && !(objPKey instanceof JSONNull) && objPKey.toString().length() != 0) continue;
            list2.add(iEntity);
        }
        list.clear();
        list.addAll(list2);
    }

    @Override
    public String getParentDEField() {
        return this.strParentDEField;
    }

    protected void setParentDEField(String strParentDEField) {
        this.strParentDEField = strParentDEField;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataQueryCodeCondImpl;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DEDataSetCond
extends DEDataQueryCodeCondImpl
implements IDEDataSetCond {
    private String strDEDataQueryName = "";

    @Override
    public String getDEDataQueryName() {
        return this.strDEDataQueryName;
    }

    public void setDEDataQueryName(String strDEDataQueryName) {
        this.strDEDataQueryName = strDEDataQueryName;
    }

    public static JSONObject toJSONObject(IDEDataSetCond iDEDataSetCond, JSONObject jsonObject) throws Exception {
        Iterator<IDEDataQueryCodeCond> conds;
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName())) {
            JSONObjectHelper.put(jsonObject, "dedqname", iDEDataSetCond.getDEDataQueryName());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getCondType())) {
            JSONObjectHelper.put(jsonObject, "type", iDEDataSetCond.getCondType());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getCondOp())) {
            JSONObjectHelper.put(jsonObject, "cond", iDEDataSetCond.getCondOp());
        }
        if (iDEDataSetCond.getCondValue() != null) {
            JSONObjectHelper.put(jsonObject, "condvalue", iDEDataSetCond.getCondValue());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEFName())) {
            JSONObjectHelper.put(jsonObject, "defname", iDEDataSetCond.getDEFName());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEFieldExp())) {
            JSONObjectHelper.put(jsonObject, "defexp", iDEDataSetCond.getDEFieldExp());
        }
        if (iDEDataSetCond.getStdDataType() != 0) {
            JSONObjectHelper.put(jsonObject, "datatype", iDEDataSetCond.getStdDataType());
        }
        if (iDEDataSetCond.isNotMode()) {
            JSONObjectHelper.put(jsonObject, "not", iDEDataSetCond.isNotMode());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getCustomCond())) {
            JSONObjectHelper.put(jsonObject, "customcond", iDEDataSetCond.getCustomCond());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getValueFunc())) {
            JSONObjectHelper.put(jsonObject, "func", iDEDataSetCond.getValueFunc());
        }
        if (!StringHelper.isNullOrEmpty(iDEDataSetCond.getPredefinedCode())) {
            JSONObjectHelper.put(jsonObject, "predefined", iDEDataSetCond.getPredefinedCode());
        }
        if ((conds = iDEDataSetCond.getChildDEDataQueryConds()) != null) {
            ArrayList<JSONObject> childCondList = new ArrayList<JSONObject>();
            while (conds.hasNext()) {
                IDEDataQueryCodeCond iDEDataQueryCodeCond = conds.next();
                if (!(iDEDataQueryCodeCond instanceof IDEDataSetCond)) continue;
                JSONObject childJsonObject = DEDataSetCond.toJSONObject((IDEDataSetCond)iDEDataQueryCodeCond, null);
                childCondList.add(childJsonObject);
            }
            if (childCondList.size() > 0) {
                JSONObjectHelper.put(jsonObject, "conds", JSONArray.fromArray((Object[])childCondList.toArray()));
            }
        }
        return jsonObject;
    }

    public static IDEDataSetCond fromJSONObject(JSONObject jsonObject) throws Exception {
        JSONArray ja;
        String strPredefinedCode;
        String strValueFunc;
        String strCustomCond;
        boolean bNotMode;
        int nDataType;
        String strDEFieldExp;
        String strDEFName;
        String strCondValue;
        String strCondOp;
        String strCondType;
        DEDataSetCond deDataSetCond = new DEDataSetCond();
        String strDEDataQueryName = jsonObject.optString("dedqname");
        if (!StringHelper.isNullOrEmpty(strDEDataQueryName)) {
            deDataSetCond.setDEDataQueryName(strDEDataQueryName);
        }
        if (!StringHelper.isNullOrEmpty(strCondType = jsonObject.optString("type"))) {
            deDataSetCond.setCondType(strCondType);
        }
        if (!StringHelper.isNullOrEmpty(strCondOp = jsonObject.optString("cond"))) {
            deDataSetCond.setCondOp(strCondOp);
        }
        if ((strCondValue = jsonObject.optString("condvalue")) != null) {
            deDataSetCond.setCondValue(strCondValue);
        }
        if (!StringHelper.isNullOrEmpty(strDEFName = jsonObject.optString("defname"))) {
            deDataSetCond.setDEFName(strDEFName);
        }
        if (!StringHelper.isNullOrEmpty(strDEFieldExp = jsonObject.optString("defexp"))) {
            deDataSetCond.setDEFieldExp(strDEFieldExp);
        }
        if ((nDataType = jsonObject.optInt("datatype", 0)) != 0) {
            deDataSetCond.setStdDataType(nDataType);
        }
        if (bNotMode = jsonObject.optBoolean("not", false)) {
            deDataSetCond.setNotMode(bNotMode);
        }
        if (!StringHelper.isNullOrEmpty(strCustomCond = jsonObject.optString("customcond"))) {
            deDataSetCond.setCustomCond(strCustomCond);
        }
        if (!StringHelper.isNullOrEmpty(strValueFunc = jsonObject.optString("func"))) {
            deDataSetCond.setValueFunc(strValueFunc);
        }
        if (!StringHelper.isNullOrEmpty(strPredefinedCode = jsonObject.optString("predefined"))) {
            deDataSetCond.setPredefinedCond(strPredefinedCode);
        }
        if ((ja = jsonObject.optJSONArray("conds")) != null) {
            int i = 0;
            while (i < ja.length()) {
                JSONObject childJsonObject = (JSONObject)ja.get(i);
                IDEDataSetCond childDEDataSetCond = DEDataSetCond.fromJSONObject(childJsonObject);
                deDataSetCond.addChildDEDataQueryCond(childDEDataSetCond);
                ++i;
            }
        }
        return deDataSetCond;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.db.ISelectFieldFilter;
import net.ibizsys.paas.db.ISelectGroupFilter;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectFilterBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectGroupFilter
extends SelectFilterBase
implements ISelectGroupFilter {
    public static final String ATTR_NOT = "not";
    public static final String ATTR_CONDS = "conds";
    protected ArrayList<IDEDataQueryCodeCond> list = null;

    public SelectGroupFilter() {
        this.strCondOp = "AND";
    }

    @Override
    public String getCondType() {
        return "GROUP";
    }

    public void setNotMode(boolean bNotMode) {
        this.bNotMode = bNotMode;
    }

    @Override
    public ArrayList<IDEDataQueryCodeCond> getSelectFilterList(boolean bCreateIfNotExists) {
        if (this.list == null && bCreateIfNotExists) {
            this.list = new ArrayList();
        }
        return this.list;
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        if (this.list == null) {
            return null;
        }
        return this.list.iterator();
    }

    public static JSONObject toJSONObject(ISelectGroupFilter iSelectGroupFilter, JSONObject jsonObject) throws Exception {
        Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds;
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if (iSelectGroupFilter.isNotMode()) {
            JSONObjectHelper.put(jsonObject, ATTR_NOT, iSelectGroupFilter.isNotMode());
        }
        if ((deDataQueryCodeConds = iSelectGroupFilter.getChildDEDataQueryConds()) != null) {
            ArrayList<JSONObject> joList = new ArrayList<JSONObject>();
            while (deDataQueryCodeConds.hasNext()) {
                IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
                if (iDEDataQueryCodeCond instanceof ISelectGroupFilter) {
                    joList.add(SelectGroupFilter.toJSONObject((ISelectGroupFilter)iDEDataQueryCodeCond, null));
                    continue;
                }
                if (!(iDEDataQueryCodeCond instanceof ISelectFieldFilter)) continue;
                joList.add(SelectFieldFilter.toJSONObject((ISelectFieldFilter)iDEDataQueryCodeCond, null));
            }
            if (joList.size() > 0) {
                jsonObject.put(ATTR_CONDS, (Object)JSONArray.fromCollection(joList));
            }
        }
        SelectFilterBase.toJSONObject(iSelectGroupFilter, jsonObject);
        return jsonObject;
    }

    public static ISelectGroupFilter fromJSONObject(JSONObject jsonObject) throws Exception {
        JSONArray condsJA;
        SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
        boolean bNotMode = jsonObject.optBoolean(ATTR_NOT, false);
        if (bNotMode) {
            selectGroupFilter.setNotMode(bNotMode);
        }
        if ((condsJA = jsonObject.optJSONArray(ATTR_CONDS)) != null) {
            int i = 0;
            while (i < condsJA.length()) {
                JSONObject jo = condsJA.getJSONObject(i);
                String strCondType = jo.optString("type");
                if (StringHelper.compare(strCondType, "GROUP", true) == 0) {
                    selectGroupFilter.getSelectFilterList(true).add(SelectGroupFilter.fromJSONObject(jo));
                } else if (StringHelper.compare(strCondType, "DEFIELD", true) == 0) {
                    selectGroupFilter.getSelectFilterList(true).add(SelectFieldFilter.fromJSONObject(jo));
                }
                ++i;
            }
        }
        return selectGroupFilter;
    }
}


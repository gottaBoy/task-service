/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.db.ISelectFieldFilter;
import net.ibizsys.paas.db.SelectFilterBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class SelectFieldFilter
extends SelectFilterBase
implements ISelectFieldFilter {
    public static final String ATTR_CONDOP = "cond";
    public static final String ATTR_DEFNAME = "defname";
    public static final String ATTR_CONDVALUE = "condvalue";
    public static final String ATTR_CUSTOMCOND = "customcond";
    public static final String ATTR_DEFIELDEXP = "defexp";
    public static final String ATTR_DATATYPE = "datatype";
    public static final String ATTR_PREDEFINED = "predefined";
    public static final String ATTR_FUNC = "func";
    private static Object UnsetCondValue = new Object();
    private Object objCondValue = UnsetCondValue;

    @Override
    public String getCondType() {
        return "DEFIELD";
    }

    public void setDEFName(String strDEFName) {
        this.strDEFName = strDEFName;
    }

    public void setCondValue(String strCondValue) {
        this.strCondValue = strCondValue;
    }

    @Override
    public Object getCondObjectValue() throws Exception {
        if (this.objCondValue == UnsetCondValue) {
            return DataTypeHelper.parse(this.getStdDataType(), super.getCondValue());
        }
        return this.objCondValue;
    }

    @Override
    public String getCondValue() {
        if (this.objCondValue == UnsetCondValue) {
            return super.getCondValue();
        }
        if (this.objCondValue == null) {
            return null;
        }
        if (this.objCondValue instanceof String) {
            return (String)this.objCondValue;
        }
        return this.objCondValue.toString();
    }

    public void setCondObjectValue(Object objCondValue) {
        this.objCondValue = objCondValue;
    }

    public void resetCondObjectValue() {
        this.objCondValue = UnsetCondValue;
    }

    public void setValueFunc(String strValueFunc) {
        this.strValueFunc = strValueFunc;
    }

    public static JSONObject toJSONObject(ISelectFieldFilter iSelectFieldFilter, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        Object objCondValue = iSelectFieldFilter.getCondObjectValue();
        JSONObjectHelper.put(jsonObject, ATTR_CONDVALUE, objCondValue);
        if (iSelectFieldFilter instanceof IDEDataQueryCodeCond) {
            ISelectFieldFilter iDEDataQueryCodeCond = iSelectFieldFilter;
            if (iDEDataQueryCodeCond.getCondOp() != null) {
                JSONObjectHelper.put(jsonObject, ATTR_CONDOP, iDEDataQueryCodeCond.getCondOp());
            }
            if (iDEDataQueryCodeCond.getDEFName() != null) {
                JSONObjectHelper.put(jsonObject, ATTR_DEFNAME, iDEDataQueryCodeCond.getDEFName());
            }
            if (iDEDataQueryCodeCond.getValueFunc() != null) {
                JSONObjectHelper.put(jsonObject, ATTR_FUNC, iDEDataQueryCodeCond.getValueFunc());
            }
        }
        SelectFilterBase.toJSONObject(iSelectFieldFilter, jsonObject);
        return jsonObject;
    }

    public static ISelectFieldFilter fromJSONObject(JSONObject jsonObject) throws Exception {
        String strFunc;
        String strDEFName;
        String strCondOp;
        SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
        Object objCondValue = jsonObject.opt(ATTR_CONDVALUE);
        if (objCondValue != null) {
            selectFieldFilter.setCondObjectValue(objCondValue);
        }
        if ((strCondOp = jsonObject.optString(ATTR_CONDOP, null)) != null) {
            selectFieldFilter.setCondOp(strCondOp);
        }
        if ((strDEFName = jsonObject.optString(ATTR_DEFNAME, null)) != null) {
            selectFieldFilter.setDEFName(strDEFName);
        }
        if ((strFunc = jsonObject.optString(ATTR_FUNC, null)) != null) {
            selectFieldFilter.setValueFunc(strFunc);
        }
        return selectFieldFilter;
    }
}


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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectContext
extends SelectCond
implements ISelectContext {
    public static final String ATTR_SELECTFIELDS = "fields";
    public static final String ATTR_DEDATAQUERYNAME = "dedqname";
    public static final String ATTR_VIEWLEVEL = "viewlevel";
    public static final String ATTR_SORT = "sort";
    public static final String ATTR_SORTDIR = "sortdir";
    private ArrayList<ISelectField> selectFieldList = null;
    private String strDEDataQueryName = null;
    private IWebContext iWebContext = null;
    private int nViewLevel = 0;
    private String strSort = null;
    private String strSortDir = null;

    @Override
    public Iterator<ISelectField> getSelectFields() {
        if (this.selectFieldList == null) {
            return null;
        }
        return this.selectFieldList.iterator();
    }

    public void addSelectField(ISelectField iSelectField) {
        if (this.selectFieldList == null) {
            this.selectFieldList = new ArrayList();
        }
        this.selectFieldList.add(iSelectField);
    }

    public void addSelectField(String strName) {
        this.addSelectField(SelectField.create(strName));
    }

    public void addSelectField(String strName, String strAlias) {
        this.addSelectField(SelectField.create(strName, strAlias));
    }

    public void addSelectField(String strName, String strAlias, String strFunc) {
        this.addSelectField(SelectField.create(strName, strAlias, strFunc));
    }

    @Override
    public String getDEDataQueryName() {
        return this.strDEDataQueryName;
    }

    public void setDEDataQueryName(String strDEDataQueryName) {
        this.strDEDataQueryName = strDEDataQueryName;
    }

    @Override
    public IWebContext getWebContext() {
        if (this.iWebContext == null) {
            return WebContext.getCurrent();
        }
        return null;
    }

    public void setWebContext(IWebContext iWebContext) {
        this.iWebContext = iWebContext;
    }

    @Override
    public int getViewLevel() {
        return this.nViewLevel;
    }

    protected void setViewLevel(int nViewLevel) {
        this.nViewLevel = nViewLevel;
    }

    @Override
    protected void onReset() {
        this.selectFieldList = null;
        this.strDEDataQueryName = null;
        this.iWebContext = null;
        this.nViewLevel = 0;
        this.strSort = null;
        this.strSortDir = null;
        super.onReset();
    }

    public static JSONObject toJSONObject(ISelectContext iSelectContext, JSONObject jsonObject) throws Exception {
        Iterator<ISelectField> selectFields;
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if ((selectFields = iSelectContext.getSelectFields()) != null) {
            ArrayList<JSONObject> joList = new ArrayList<JSONObject>();
            while (selectFields.hasNext()) {
                ISelectField iSelectField = selectFields.next();
                joList.add(SelectField.toJSONObject(iSelectField));
            }
            JSONObjectHelper.put(jsonObject, ATTR_SELECTFIELDS, JSONArray.fromCollection(joList));
        }
        if (iSelectContext.getDEDataQueryName() != null) {
            JSONObjectHelper.put(jsonObject, ATTR_DEDATAQUERYNAME, iSelectContext.getDEDataQueryName());
        }
        JSONObjectHelper.put(jsonObject, ATTR_VIEWLEVEL, iSelectContext.getViewLevel());
        if (!StringHelper.isNullOrEmpty(iSelectContext.getSort())) {
            JSONObjectHelper.put(jsonObject, ATTR_SORT, iSelectContext.getSort());
        }
        if (!StringHelper.isNullOrEmpty(iSelectContext.getSortDir())) {
            JSONObjectHelper.put(jsonObject, ATTR_SORTDIR, iSelectContext.getSortDir());
        }
        SelectCond.toJSONObject(iSelectContext, jsonObject);
        return jsonObject;
    }

    public static ISelectContext fromJSONObject(JSONObject jsonObject) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectContext.fromJSONObject(jsonObject, selectContext);
        return selectContext;
    }

    public static ISelectContext fromJSONObject(JSONObject jsonObject, SelectContext selectContext) throws Exception {
        JSONArray selectFields = jsonObject.optJSONArray(ATTR_SELECTFIELDS);
        if (selectFields != null) {
            int i = 0;
            while (i < selectFields.length()) {
                selectContext.addSelectField(SelectField.fromJSONObject(selectFields.getJSONObject(i)));
                ++i;
            }
        }
        selectContext.setDEDataQueryName(jsonObject.optString(ATTR_DEDATAQUERYNAME));
        selectContext.setViewLevel(jsonObject.optInt(ATTR_VIEWLEVEL, selectContext.getViewLevel()));
        selectContext.setSort(jsonObject.optString(ATTR_SORT));
        selectContext.setSortDir(jsonObject.optString(ATTR_SORTDIR));
        SelectCond.fromJSONObject(jsonObject, selectContext);
        return selectContext;
    }

    @Override
    public String getSort() {
        return this.strSort;
    }

    @Override
    public String getSortDir() {
        return this.strSortDir;
    }

    public void setSort(String strSort) {
        this.strSort = strSort;
    }

    public void setSortDir(String strSortDir) {
        this.strSortDir = strSortDir;
    }

    @Override
    public String getOrderInfo() {
        String strOrderInfo = super.getOrderInfo();
        if (StringHelper.isNullOrEmpty(strOrderInfo) && !StringHelper.isNullOrEmpty(this.getSort())) {
            return StringHelper.format("ORDER BY %1$s %2$s", this.getSort(), this.getSortDir() == null ? "" : this.getSortDir());
        }
        return strOrderInfo;
    }
}


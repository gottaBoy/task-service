/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class SelectField
implements ISelectField {
    public static final String ATTR_NAME = "name";
    public static final String ATTR_ALIAS = "alias";
    public static final String ATTR_FUNC = "func";
    private String strName = null;
    private String strAlias = null;
    private String strFunc = null;

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public String getAlias() {
        return this.strAlias;
    }

    @Override
    public String getFunc() {
        return this.strFunc;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setAlias(String strAlias) {
        this.strAlias = strAlias;
    }

    public void setFunc(String strFunc) {
        this.strFunc = strFunc;
    }

    public static JSONObject toJSONObject(ISelectField iSelectField) throws Exception {
        return SelectField.toJSONObject(iSelectField, null);
    }

    public static JSONObject toJSONObject(ISelectField iSelectField, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if (iSelectField.getName() != null) {
            JSONObjectHelper.put(jsonObject, ATTR_NAME, iSelectField.getName());
        }
        if (iSelectField.getAlias() != null) {
            JSONObjectHelper.put(jsonObject, ATTR_ALIAS, iSelectField.getAlias());
        }
        if (iSelectField.getFunc() != null) {
            JSONObjectHelper.put(jsonObject, ATTR_FUNC, iSelectField.getFunc());
        }
        return jsonObject;
    }

    public static ISelectField fromJSONObject(JSONObject jsonObject) throws Exception {
        SelectField selectField = new SelectField();
        selectField.setName(jsonObject.optString(ATTR_NAME));
        selectField.setAlias(jsonObject.optString(ATTR_ALIAS));
        selectField.setFunc(jsonObject.optString(ATTR_FUNC));
        return selectField;
    }

    public static ISelectField create(String strName) {
        SelectField selectField = new SelectField();
        selectField.setName(strName);
        return selectField;
    }

    public static ISelectField create(String strName, String strAlias) {
        SelectField selectField = new SelectField();
        selectField.setName(strName);
        selectField.setAlias(strAlias);
        return selectField;
    }

    public static ISelectField create(String strName, String strAlias, String strFunc) {
        SelectField selectField = new SelectField();
        selectField.setName(strName);
        selectField.setAlias(strAlias);
        selectField.setFunc(strFunc);
        return selectField;
    }
}


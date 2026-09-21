/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class DataContextParam
implements IDataContextParam {
    private String strDEName = "";
    private String strDEFName = "";
    private String strReferItem = "";
    private boolean bIgnoreEmpty = false;

    public DataContextParam(String strParam) throws Exception {
        if (strParam != null) {
            JSONObject json = JSONObjectHelper.fromString(strParam);
            this.strDEName = json.optString("dename", "");
            this.strDEFName = json.optString("defname", "");
            this.bIgnoreEmpty = json.optBoolean("ignoreempty", this.bIgnoreEmpty);
        }
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getDEFName() {
        return this.strDEFName;
    }

    @Override
    public String getReferItem() {
        return this.strReferItem;
    }

    public void setReferItem(String strReferItem) {
        this.strReferItem = strReferItem;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setDEFName(String strDEFName) {
        this.strDEFName = strDEFName;
    }

    @Override
    public boolean isIgnoreEmpty() {
        return this.bIgnoreEmpty;
    }

    public void setIgnoreEmpty(boolean bIgnoreEmpty) {
        this.bIgnoreEmpty = bIgnoreEmpty;
    }
}


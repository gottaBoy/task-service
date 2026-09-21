/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppViewParam
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppViewParam;

public class PSAppViewParamImpl
implements IPSAppViewParam {
    private String strValue = "";
    private String strDesc = null;
    private String strKey = "";

    public String getValue() {
        return this.strValue;
    }

    public String getKey() {
        return this.strKey;
    }

    public String getDesc() {
        return this.strDesc;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public void setDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public void setKey(String strKey) {
        this.strKey = strKey;
    }
}


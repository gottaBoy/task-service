/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemUtil;

public abstract class SystemUtilBase
extends ModelBase2Impl
implements ISystemUtil {
    private ISystemModel iSystemModel = null;
    private String strUtilType = null;
    private HashMap<String, Object> utilParamMap = new HashMap();

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.iSystemModel = iSystemModel;
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getUtilType() {
        return this.strUtilType;
    }

    public void setUtilType(String strUtilType) {
        this.strUtilType = strUtilType;
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    @Override
    public void setUtilParam(String strParamKey, Object objValue) {
        this.utilParamMap.put(strParamKey, objValue);
    }

    public int getUtilParam(String strParam, int nDefault) {
        try {
            return DataObject.getIntegerValue(this.utilParamMap.get(strParam), nDefault);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public String getUtilParam(String strParam, String strDefault) {
        try {
            return DataObject.getStringValue(this.utilParamMap.get(strParam), strDefault);
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public double getUtilParam(String strParam, double fDefault) {
        try {
            return DataObject.getDoubleValue(this.utilParamMap.get(strParam));
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public boolean getUtilParam(String strParam, boolean bDefault) {
        try {
            return DataObject.getBoolValue(this.utilParamMap.get(strParam), bDefault);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }
}


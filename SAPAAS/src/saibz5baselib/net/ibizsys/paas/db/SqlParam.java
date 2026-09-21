/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.StringHelper;

public class SqlParam
extends ModelBaseImpl {
    protected Object objValue = null;
    protected int nDirection = 1;
    protected String strOutputParamName = "";
    protected int nDataType = 0;
    protected String strParamName = "";

    public SqlParam() {
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public SqlParam clone() {
        SqlParam callParam = new SqlParam();
        callParam.setDataType(this.nDataType);
        callParam.setDirection(this.nDirection);
        callParam.setOutputParamName(this.strOutputParamName);
        callParam.setParamName(this.strParamName);
        callParam.setValue(this.objValue);
        return callParam;
    }

    public SqlParam(Object objValue) {
        this.objValue = objValue;
    }

    public SqlParam(Object objValue, int nDataType) {
        this.objValue = objValue;
        this.nDataType = nDataType;
    }

    public Object getValue() {
        return this.objValue;
    }

    public void setValue(Object objValue) {
        this.objValue = objValue;
    }

    public int getDirection() {
        return this.nDirection;
    }

    public void setDirection(int direction) {
        this.nDirection = direction;
    }

    public String getOutputParamName() {
        if (StringHelper.isNullOrEmpty(this.strOutputParamName)) {
            return this.getParamName();
        }
        return this.strOutputParamName;
    }

    public void setOutputParamName(String strOutputParamName) {
        this.strOutputParamName = strOutputParamName;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public String getParamName() {
        if (StringHelper.isNullOrEmpty(this.strParamName)) {
            return this.getName();
        }
        return this.strParamName;
    }

    public void setParamName(String strParamName) {
        this.strParamName = strParamName;
    }
}


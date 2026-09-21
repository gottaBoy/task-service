/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.ModelBase3Impl;

public class DEDataSetGroupParamModel
extends ModelBase3Impl
implements IDEDataSetGroupParam {
    private IDEDataSet iDEDataSet = null;
    private String strGroupCode = null;
    private String strSortDir = null;
    private int nSortOrder = -1;
    private boolean bEnableGroup = false;
    private String[] groupFields = null;
    private boolean bReCalc = false;

    public void init(IDEDataSet iDEDataSet) throws Exception {
        this.iDEDataSet = iDEDataSet;
        this.onInit();
    }

    @Override
    public String getGroupCode() {
        return this.strGroupCode;
    }

    @Override
    public String getSortDir() {
        return this.strSortDir;
    }

    @Override
    public int getSortOrder() {
        return this.nSortOrder;
    }

    public void setGroupCode(String strGroupCode) {
        this.strGroupCode = strGroupCode;
    }

    public void setSortDir(String strSortDir) {
        this.strSortDir = strSortDir;
    }

    public void setSortOrder(int nSortOrder) {
        this.nSortOrder = nSortOrder;
    }

    @Override
    public IDEDataSet getDEDataSet() {
        return this.iDEDataSet;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String[] getGroupFields() {
        return this.groupFields;
    }

    public void setGroupFields(String[] groupFields) {
        this.groupFields = groupFields;
    }

    @Override
    public boolean isReCalc() {
        return this.bReCalc;
    }

    public void setReCalc(boolean bRecalc) {
        this.bReCalc = bRecalc;
    }

    @Override
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    public void setEnableGroup(boolean bEnableGroup) {
        this.bEnableGroup = bEnableGroup;
    }
}


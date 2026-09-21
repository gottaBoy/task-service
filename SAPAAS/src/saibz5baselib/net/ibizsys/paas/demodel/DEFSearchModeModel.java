/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ModelBase3Impl;

public class DEFSearchModeModel
extends ModelBase3Impl
implements IDEFSearchMode {
    private IDEField iDEField = null;
    private String strValueFunc = null;
    private String strValueOp = null;

    public void init() throws Exception {
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getValueFunc() {
        return this.strValueFunc;
    }

    @Override
    public String getValueOp() {
        return this.strValueOp;
    }

    @Override
    public String getDEFName() {
        return this.iDEField.getName();
    }

    public IDEField getDEField() {
        return this.iDEField;
    }

    public void setDEField(IDEField iDEField) {
        this.iDEField = iDEField;
    }

    public void setValueFunc(String strValueFunc) {
        this.strValueFunc = strValueFunc;
    }

    public void setValueOp(String strValueOp) {
        this.strValueOp = strValueOp;
    }
}


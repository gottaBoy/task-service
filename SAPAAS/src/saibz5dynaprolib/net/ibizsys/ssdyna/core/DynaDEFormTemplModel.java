/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase2Impl
 */
package net.ibizsys.ssdyna.core;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.ssdyna.core.IDynaDEFormTemplModel;

public class DynaDEFormTemplModel
extends ModelBase2Impl
implements IDynaDEFormTemplModel {
    private String strDEFormId = null;

    @Override
    public String getDEFormId() {
        return this.strDEFormId;
    }

    public void setDEFormId(String strDEFormId) {
        this.strDEFormId = strDEFormId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }
}


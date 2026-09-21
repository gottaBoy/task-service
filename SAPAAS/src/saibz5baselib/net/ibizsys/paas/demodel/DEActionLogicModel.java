/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEActionLogicModel;

public class DEActionLogicModel
extends ModelBase3Impl
implements IDEActionLogicModel {
    private String strDEName = "";
    private String strDEActionName = "";
    private boolean bCloneParam = false;
    private boolean bIgnoreException = false;

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    @Override
    public boolean isCloneParam() {
        return this.bCloneParam;
    }

    @Override
    public boolean isIgnoreException() {
        return this.bIgnoreException;
    }

    public void setCloneParam(boolean bCloneParam) {
        this.bCloneParam = bCloneParam;
    }

    public void setIgnoreException(boolean bIgnoreException) {
        this.bIgnoreException = bIgnoreException;
    }
}


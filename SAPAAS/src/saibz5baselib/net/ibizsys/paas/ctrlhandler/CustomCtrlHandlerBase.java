/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICustomCtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

public abstract class CustomCtrlHandlerBase
extends CtrlHandlerBase
implements ICustomCtrlHandler {
    private String strCustomTag = null;
    private String strCustomTag2 = null;
    private String strDEActionName = null;
    private String strDEDataSetName = null;
    private String strDEName = null;

    @Override
    public String getCustomTag() {
        return this.strCustomTag;
    }

    @Override
    public String getCustomTag2() {
        return this.strCustomTag2;
    }

    protected void setCustomTag(String strCustomTag) {
        this.strCustomTag = strCustomTag;
    }

    protected void setCustomTag2(String strCustomTag2) {
        this.strCustomTag2 = strCustomTag2;
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return null;
    }

    public String getDEName() {
        return this.strDEName;
    }

    protected void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public String getDEActionName() {
        return this.strDEActionName;
    }

    protected void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    protected void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }
}


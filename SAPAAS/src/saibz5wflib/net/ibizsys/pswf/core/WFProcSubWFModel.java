/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public class WFProcSubWFModel
implements IWFProcSubWFModel {
    private String strId = "";
    private String strName = "";
    private String strDEName = "";
    private String strWFId = "";
    private String strDEDSName = "";
    private IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase = null;
    private boolean bSuspendDefault = false;
    private String strWFVerId = null;

    @Override
    public void init(IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase) throws Exception {
        this.iWFEmbedWFProcessModelBase = iWFEmbedWFProcessModelBase;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase() {
        return this.iWFEmbedWFProcessModelBase;
    }

    @Override
    public IWFModel getWFModel() {
        return null;
    }

    @Override
    public String getWFId() {
        return this.strWFId;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getDEDSName() {
        return this.strDEDSName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setWFId(String strWFId) {
        this.strWFId = strWFId;
    }

    public void setDEDSName(String strDEDSName) {
        this.strDEDSName = strDEDSName;
    }

    @Override
    public boolean isSuspendDefault() {
        return this.bSuspendDefault;
    }

    public void setSuspendDefault(boolean bSuspendDefault) {
        this.bSuspendDefault = bSuspendDefault;
    }

    @Override
    public IWFVersionModel getWFVersionModel() {
        return null;
    }

    @Override
    public String getWFVerId() {
        return this.strWFVerId;
    }

    public void setWFVerId(String strWFVerId) {
        this.strWFVerId = strWFVerId;
    }
}


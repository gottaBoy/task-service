/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcess
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFDEActionProcessModel;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.WFDEActionProcess;
import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFDEActionProcessModelBase
extends WFProcessModelBase
implements IWFDEActionProcessModel {
    private ArrayList<IWFDEActionProcessParamModel> wfDEActionProcessParamModelList = new ArrayList();
    private String strDEActionName = "";

    @Override
    public Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels() {
        return this.wfDEActionProcessParamModelList.iterator();
    }

    protected void registerWFDEActionProcessParamModel(IWFDEActionProcessParamModel iWFDEActionProcessParamModel) {
        this.wfDEActionProcessParamModelList.add(iWFDEActionProcessParamModel);
    }

    @Override
    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    @Override
    protected IWFProcess createWFProcess() throws Exception {
        return new WFDEActionProcess();
    }

    public String getWFProcessType() {
        return "PROCESS";
    }
}


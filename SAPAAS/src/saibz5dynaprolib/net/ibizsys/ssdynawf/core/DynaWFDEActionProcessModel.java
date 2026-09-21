/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFDEActionProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFProcessParam
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFDEActionProcessModelBase
 *  net.ibizsys.pswf.core.WFDEActionProcessParamModel
 */
package net.ibizsys.ssdynawf.core;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFDEActionProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFDEActionProcessModelBase;
import net.ibizsys.pswf.core.WFDEActionProcessParamModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFDEActionProcessModel
extends WFDEActionProcessModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFDEActionProcess iPSWFProcess = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getDEActionName())) {
            this.setDEActionName(this.iPSWFProcess.getDEActionName());
        }
        this.setBPMNModelId(iPSWFProcess.getBPMNModelId());
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator psWFProcessParams = this.iPSWFProcess.getPSWFProcessParams();
        if (psWFProcessParams != null) {
            while (psWFProcessParams.hasNext()) {
                IPSWFProcessParam iPSWFProcessParam = (IPSWFProcessParam)psWFProcessParams.next();
                WFDEActionProcessParamModel procParam = new WFDEActionProcessParamModel();
                procParam.setDstField(iPSWFProcessParam.getDstField());
                procParam.setSrcValueType(iPSWFProcessParam.getSrcValueType());
                procParam.setSrcValue(iPSWFProcessParam.getSrcValue());
                this.registerWFDEActionProcessParamModel((IWFDEActionProcessParamModel)procParam);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 *  net.ibizsys.pswf.core.WFDEActionProcessModelBase
 *  net.ibizsys.pswf.core.WFDEActionProcessParamModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFDEActionProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessParam;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.WFDEActionProcessModelBase;
import net.ibizsys.pswf.core.WFDEActionProcessParamModel;

public class PSJITWFDEActionProcessModel
extends WFDEActionProcessModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFDEActionProcess iPSWFProcess = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getDEActionName())) {
            this.setDEActionName(this.iPSWFProcess.getDEActionName());
        }
        this.init(iPSJITWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator<IPSWFProcessParam> psWFProcessParams = this.iPSWFProcess.getPSWFProcessParams();
        if (psWFProcessParams != null) {
            while (psWFProcessParams.hasNext()) {
                IPSWFProcessParam iPSWFProcessParam = psWFProcessParams.next();
                WFDEActionProcessParamModel procParam = new WFDEActionProcessParamModel();
                procParam.setDstField(iPSWFProcessParam.getDstField());
                procParam.setSrcValueType(iPSWFProcessParam.getSrcValueType());
                procParam.setSrcValue(iPSWFProcessParam.getSrcValue());
                this.registerWFDEActionProcessParamModel((IWFDEActionProcessParamModel)procParam);
            }
        }
    }
}


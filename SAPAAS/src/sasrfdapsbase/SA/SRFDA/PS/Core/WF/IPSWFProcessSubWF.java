/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFProcSubWFModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8282\u70b9\u5b50\u6d41\u7a0b\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFProcSubWF")
public interface IPSWFProcessSubWF
extends IWFProcSubWFModel,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSWFEmbedWFProcessBase var2, PSWFProcSubWF var3) throws Exception;

    public IPSWFProcess getPSWFProcess();

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSWorkflow getPSWorkflow();

    public IPSWFVersion getPSWFVersion();

    @Override
    public String getCodeName();
}


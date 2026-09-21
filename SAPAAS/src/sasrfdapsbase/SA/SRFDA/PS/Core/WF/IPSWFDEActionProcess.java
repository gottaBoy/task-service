/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFDEActionProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import net.ibizsys.pswf.core.IWFDEActionProcessModel;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"PROCESS"}, description="\u7528\u4e8e\u8c03\u7528\u5916\u90e8\u670d\u52a1")
public interface IPSWFDEActionProcess
extends IPSWFProcess,
IWFDEActionProcessModel {
    @Override
    public IPSDEWF getPSDEWF();

    public IPSDataEntity getPSDataEntity();

    public IPSDEAction getPSDEAction();
}


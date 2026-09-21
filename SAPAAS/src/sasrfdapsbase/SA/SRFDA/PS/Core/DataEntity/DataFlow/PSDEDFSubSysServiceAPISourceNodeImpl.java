/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSubSysServiceAPISourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSUBSYSSERVICEAPISOURCE"})
public class PSDEDFSubSysServiceAPISourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFSubSysServiceAPISourceNode {
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
    private IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSubSysServiceAPI();
        this.getPSSubSysServiceAPIDEMethod();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSUBSYSSERVICEAPIID"})
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.iPSSubSysServiceAPI == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSUBSYSSERVICEAPIID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3");
            }
            this.iPSSubSysServiceAPI = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSubSysServiceAPI(this.psDELogicNode.getPSSUBSYSSERVICEAPIID());
        }
        return this.iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53", hideempty=true, dumpref=true, ignorepf=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception {
        return this.getPSSubSysServiceAPIDEMethod().getPSSubSysServiceAPIDE();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", hideempty=true, dumpref=true, ignorepf=true, from="IPSSubSysServiceAPIDE", fields={"PSSUBSYSSADETAILID"})
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        if (this.iPSSubSysServiceAPIDEMethod == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSUBSYSSADETAILID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5");
            }
            this.iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)this.getPSSubSysServiceAPI().getPSSubSysServiceAPIMethod(this.psDELogicNode.getPSSUBSYSSADETAILID(), false);
        }
        return this.iPSSubSysServiceAPIDEMethod;
    }
}


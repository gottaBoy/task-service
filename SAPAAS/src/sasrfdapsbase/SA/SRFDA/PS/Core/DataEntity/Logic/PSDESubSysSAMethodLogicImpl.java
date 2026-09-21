/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESubSysSAMethodLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESubSysSAMethodLogicImpl
extends PSDELogicNodeImpl
implements IPSDESubSysSAMethodLogic {
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
            this.iPSSubSysServiceAPI = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSubSysServiceAPI(this.psDELogicNode.getPSSUBSYSSERVICEAPIID());
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

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDERawWebCallLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERawWebCallLogicImpl
extends PSDELogicNodeImpl
implements IPSDERawWebCallLogic {
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;

    @Override
    protected int onCheck() throws Exception {
        this.getPSSubSysServiceAPI();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSUBSYSSERVICEAPIID"})
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.iPSSubSysServiceAPI == null && !StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSUBSYSSERVICEAPIID())) {
            this.iPSSubSysServiceAPI = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSubSysServiceAPI(this.psDELogicNode.getPSSUBSYSSERVICEAPIID());
        }
        return this.iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84", fields={"PARAM4"})
    public String getRequestPath() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u6a21\u5f0f", codelist="RequestMethod", fields={"PARAM1"})
    public String getRequestMethod() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5185\u5bb9\u7c7b\u578b", codelist="ServiceReqContentType", fields={"PARAM2"})
    public String getBodyContentType() {
        return this.psDELogicNode.getPARAM2();
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

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u54cd\u5e94\u6570\u636e\u5bf9\u8c61", ignoredumpvalues="false", fields={"PARAM7"})
    public boolean isReturnRepEntity() {
        return this.psDELogicNode.GetParamIntValue("PARAM7", 0) == 1;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLinkSingleCond;
import SA.SRFDA.PS.Core.WF.PSWFLinkCondImpl;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSWFLinkSingleCondImpl
extends PSWFLinkCondImpl
implements IPSWFLinkSingleCond {
    protected String strDstFieldName = "";
    private String strParamType = "";

    @Override
    protected void onInit() throws Exception {
        this.strDstFieldName = this.psWFLinkCond.getCUSTOMDSTPARAM();
        if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
            this.strDstFieldName = this.psWFLinkCond.getDSTPSDEFNAME();
        }
        this.strParamType = this.psWFLinkCond.getPARAMTYPE();
        super.onInit();
    }

    @Override
    public String getPSDBValueOPId() {
        return this.psWFLinkCond.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c", fields={"CONDVALUE"})
    public String getParamValue() {
        return this.psWFLinkCond.getCONDVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027", fields={"CUSTOMDSTPARAM", "DSTPSDEFNAME"})
    public String getFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u64cd\u4f5c", fields={"PSDBVALUEOPID"})
    public String getCondOP() {
        return this.getPSDBValueOPId();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="DEFVRParamType", fields={"PARAMTYPE"})
    public String getParamType() {
        return this.strParamType;
    }
}


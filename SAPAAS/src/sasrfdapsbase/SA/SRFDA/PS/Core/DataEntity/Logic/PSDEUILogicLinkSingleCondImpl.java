/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkSingleCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicLinkCondImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEUILogicLinkCond", typevalues={"SINGLE"})
public class PSDEUILogicLinkSingleCondImpl
extends PSDEUILogicLinkCondImpl
implements IPSDEUILogicLinkSingleCond {
    protected String strDstFieldName = "";
    private String strParamType = "";

    @Override
    protected void onInit() throws Exception {
        this.strDstFieldName = this.psDELogicLinkCond.getCUSTOMDSTPARAM();
        if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
            this.strDstFieldName = this.psDELogicLinkCond.getDSTPSDEFNAME();
        }
        this.strParamType = this.psDELogicLinkCond.getPARAMTYPE();
        super.onInit();
    }

    public String getPSDBValueOPId() {
        return this.psDELogicLinkCond.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u503c\uff08\u65e7\uff09")
    public String getValue() {
        return this.psDELogicLinkCond.getCONDVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstLogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicLinkCond.getDSTPSDLPARAMID())) {
            return null;
        }
        return this.iPSDEUILogicLink.getPSDEUILogic().getPSDEUILogicParam(this.psDELogicLinkCond.getDSTPSDLPARAMID());
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getSrcLogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicLinkCond.getSRCPSDLPARAMID())) {
            return null;
        }
        return this.iPSDEUILogicLink.getPSDEUILogic().getPSDEUILogicParam(this.psDELogicLinkCond.getSRCPSDLPARAMID());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMDSTPARAM", "DSTPSDEFNAME"})
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u64cd\u4f5c", fields={"PSDBVALUEOPID"})
    public String getCondOP() {
        return this.getPSDBValueOPId();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="DEFVRParamType", fields={"PARAMTYPE"})
    public String getParamType() {
        return this.strParamType;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u503c", fields={"CONDVALUE"})
    public String getParamValue() {
        return this.getValue();
    }
}


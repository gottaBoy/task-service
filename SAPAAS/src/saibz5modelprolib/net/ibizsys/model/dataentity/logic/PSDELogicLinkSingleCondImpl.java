/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkSingleCond
 *  net.ibizsys.model.dataentity.logic.IPSDELogicParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkSingleCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkCondImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDELogicLinkSingleCondImpl
extends PSDELogicLinkCondImpl
implements IPSDELogicLinkSingleCond {
    protected String strDstFieldName = "";

    @Override
    protected void onInit() throws Exception {
        this.strDstFieldName = this.psDELogicLinkCond.getCUSTOMDSTPARAM();
        if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
            this.strDstFieldName = this.psDELogicLinkCond.getDSTPSDEFNAME();
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u503c\u64cd\u4f5c")
    public String getPSDBValueOPId() {
        return this.psDELogicLinkCond.getPSDBVALUEOPID();
    }

    @PSModelRTMeta(description="\u503c")
    public String getValue() {
        return this.psDELogicLinkCond.getCONDVALUE();
    }

    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSDELogicParam getDstLogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicLinkCond.getDSTPSDLPARAMID())) {
            return null;
        }
        return this.iPSDELogicLink.getPSDELogic().getPSDELogicParam(this.psDELogicLinkCond.getDSTPSDLPARAMID());
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }
}


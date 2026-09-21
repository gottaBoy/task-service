/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLinkSingleCond
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFLinkSingleCond;
import net.ibizsys.model.wf.PSWFLinkCondImpl;
import net.ibizsys.paas.util.StringHelper;

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

    public String getPSDBValueOPId() {
        return this.psWFLinkCond.getPSDBVALUEOPID();
    }

    public String getParamValue() {
        return this.psWFLinkCond.getCONDVALUE();
    }

    public String getFieldName() throws Exception {
        return this.strDstFieldName;
    }

    public String getCondOP() {
        return this.getPSDBValueOPId();
    }

    public String getParamType() {
        return this.strParamType;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFReturnLink;
import SA.SRFDA.PS.Core.WF.PSWFLinkImpl;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSWFEmbedWFReturnLinkImpl
extends PSWFLinkImpl
implements IPSWFEmbedWFReturnLink {
    protected String strNextCondition = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strNextCondition = this.psWFLink.getNEXTCOND();
        if (StringHelper.isNullOrEmpty((String)this.strNextCondition)) {
            this.strNextCondition = "ANY";
        }
    }

    @Override
    public String getNextCondition() {
        return this.strNextCondition;
    }

    public String getReturnValue() {
        return this.getName();
    }
}


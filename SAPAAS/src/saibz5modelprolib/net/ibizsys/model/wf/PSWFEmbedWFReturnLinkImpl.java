/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFEmbedWFReturnLink
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFEmbedWFReturnLink;
import net.ibizsys.model.wf.PSWFLinkImpl;
import net.ibizsys.paas.util.StringHelper;

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


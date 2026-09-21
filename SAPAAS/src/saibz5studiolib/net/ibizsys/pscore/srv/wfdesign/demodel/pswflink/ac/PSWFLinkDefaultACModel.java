/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswflink.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a93c35398cae7e2ecde2cd8e2a0f731c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFLINKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="LABEL", format="")})})
public class PSWFLinkDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFLinkDefaultACModel() {
        this.initAnnotation(PSWFLinkDefaultACModel.class);
    }
}


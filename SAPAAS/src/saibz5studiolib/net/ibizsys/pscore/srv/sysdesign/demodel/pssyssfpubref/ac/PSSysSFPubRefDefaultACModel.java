/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfpubref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8d0dd004081dd32110a36efe86633628", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSFPUBREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSFPUBREFNAME", format="")})})
public class PSSysSFPubRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSFPubRefDefaultACModel() {
        this.initAnnotation(PSSysSFPubRefDefaultACModel.class);
    }
}


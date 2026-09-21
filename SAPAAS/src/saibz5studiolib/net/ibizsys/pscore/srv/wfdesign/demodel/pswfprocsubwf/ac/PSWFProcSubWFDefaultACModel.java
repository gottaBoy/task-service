/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocsubwf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bd9a152e9fdcf118dfe6f9f36aee0bc9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFPROCSUBWFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFPROCSUBWFNAME", format="")})})
public class PSWFProcSubWFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFProcSubWFDefaultACModel() {
        this.initAnnotation(PSWFProcSubWFDefaultACModel.class);
    }
}


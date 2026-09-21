/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfworktime.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b468cd64214501ae3a47608cdae333a3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFWORKTIMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFWORKTIMENAME", format="")})})
public class PSWFWorkTimeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFWorkTimeDefaultACModel() {
        this.initAnnotation(PSWFWorkTimeDefaultACModel.class);
    }
}


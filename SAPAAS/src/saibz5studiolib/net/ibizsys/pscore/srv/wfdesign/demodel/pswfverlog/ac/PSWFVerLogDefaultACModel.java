/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfverlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2ed822e746199404b1d2812ed1ae32f0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFVERLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFVERLOGNAME", format="")})})
public class PSWFVerLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFVerLogDefaultACModel() {
        this.initAnnotation(PSWFVerLogDefaultACModel.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcengineinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1c7cfa232cf16f8f229bbfad7df29d23", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPDCENGINEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPDCENGINEINSTNAME", format="")})})
public class PSWPDCEngineInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPDCEngineInstDefaultACModel() {
        this.initAnnotation(PSWPDCEngineInstDefaultACModel.class);
    }
}


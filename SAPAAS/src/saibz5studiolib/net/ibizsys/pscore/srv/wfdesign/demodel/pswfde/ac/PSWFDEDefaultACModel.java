/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7429503461141c51ef4d76717ba37488", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFDENAME", format="")})})
public class PSWFDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFDEDefaultACModel() {
        this.initAnnotation(PSWFDEDefaultACModel.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysctrlstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="059a160d82980634391f108163a530ea", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCTRLSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCTRLSTYLENAME", format="")})})
public class PSSysCtrlStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCtrlStyleDefaultACModel() {
        this.initAnnotation(PSSysCtrlStyleDefaultACModel.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappctrlstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="37894ef1793a5b9b0a77f5e77f45b3b0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPCTRLSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPCTRLSTYLENAME", format="")})})
public class PSAppCtrlStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppCtrlStyleDefaultACModel() {
        this.initAnnotation(PSAppCtrlStyleDefaultACModel.class);
    }
}


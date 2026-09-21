/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c0bb0e0c0081e39774c0886da0633ed0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPMODULENAME", format="")})})
public class PSHelpModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpModuleDefaultACModel() {
        this.initAnnotation(PSHelpModuleDefaultACModel.class);
    }
}


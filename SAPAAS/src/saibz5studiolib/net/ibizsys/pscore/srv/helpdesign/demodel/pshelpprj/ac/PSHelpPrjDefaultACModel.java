/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpprj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6ef2e1b75ef22498b3519c6c351fcaa1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPPRJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPPRJNAME", format="")})})
public class PSHelpPrjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpPrjDefaultACModel() {
        this.initAnnotation(PSHelpPrjDefaultACModel.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpresource.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ed22063876b67beee864566c5d9697d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPRESOURCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPRESOURCENAME", format="")})})
public class PSHelpResourceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpResourceDefaultACModel() {
        this.initAnnotation(PSHelpResourceDefaultACModel.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatemodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="52b9c208d5061c8106324f1cd8f4084c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWCREATEMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWCREATEMODELNAME", format="")})})
public class PSUWCreateModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWCreateModelDefaultACModel() {
        this.initAnnotation(PSUWCreateModelDefaultACModel.class);
    }
}


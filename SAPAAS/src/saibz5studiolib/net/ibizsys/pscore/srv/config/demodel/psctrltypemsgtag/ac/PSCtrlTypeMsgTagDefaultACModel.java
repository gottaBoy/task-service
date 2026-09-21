/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrltypemsgtag.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cc7b479073e0b9b01c1c69c133ee86e4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLTYPEMSGTAGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLTYPEMSGTAGNAME", format="")})})
public class PSCtrlTypeMsgTagDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlTypeMsgTagDefaultACModel() {
        this.initAnnotation(PSCtrlTypeMsgTagDefaultACModel.class);
    }
}


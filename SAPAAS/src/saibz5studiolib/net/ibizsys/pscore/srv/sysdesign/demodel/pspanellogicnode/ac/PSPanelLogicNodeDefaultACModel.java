/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pspanellogicnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dededc705df1b30953877c9638b04a80", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELLOGICNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELLOGICNODENAME", format="")})})
public class PSPanelLogicNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelLogicNodeDefaultACModel() {
        this.initAnnotation(PSPanelLogicNodeDefaultACModel.class);
    }
}


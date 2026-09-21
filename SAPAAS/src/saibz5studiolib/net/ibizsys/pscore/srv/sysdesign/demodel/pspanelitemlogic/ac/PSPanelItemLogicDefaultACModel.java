/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pspanelitemlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9a4a1168233a98e62a8ccb3005cc0b8f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELITEMLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELITEMLOGICNAME", format="")})})
public class PSPanelItemLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelItemLogicDefaultACModel() {
        this.initAnnotation(PSPanelItemLogicDefaultACModel.class);
    }
}


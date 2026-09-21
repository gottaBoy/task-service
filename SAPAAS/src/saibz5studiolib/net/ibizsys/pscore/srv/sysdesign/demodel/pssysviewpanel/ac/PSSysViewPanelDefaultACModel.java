/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewpanel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b444e5012f52c81abc675e78d2dc5465", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELNAME", format="")})})
public class PSSysViewPanelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysViewPanelDefaultACModel() {
        this.initAnnotation(PSSysViewPanelDefaultACModel.class);
    }
}

